package com.example.lab_8

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.MenuItem
import android.view.View
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.lab_8.adapters.PlaceAdapter
import com.example.lab_8.dataBase.Character
import com.example.lab_8.dataBase.RickAndMortyDB


class CharactersFragment : Fragment(R.layout.fragment_characters), PlaceAdapter.RecyclerViewCharacterClickHandler{
    private lateinit var recyclerView: RecyclerView
    private lateinit var placeList: MutableList<Character>

    override fun onViewCreated(view: View,savedInstanceState: Bundle?) {
        super.onViewCreated(view,savedInstanceState)

        recyclerView = view.findViewById(R.id.recycler_placeList)

        setupRecycler()
        //onOptionsItemSelected(menu)

    }

    private fun setupRecycler(){
        placeList = RickAndMortyDB.getCharacters()
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = PlaceAdapter(placeList, this)
    }

    override fun onCharacterClick(character: Character) {
        val action = CharactersFragmentDirections.actionCharactersFragmentToDetailsCharacterFragment(character)
        requireView().findNavController().navigate(action)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){
            R.id.menu_itemAscendentSort ->{
                placeList.sortBy { character ->  character.name}
                true
            }
            R.id.menu_itemDescendentSort ->{
                placeList.sortBy { character ->  character.name}
                true
            }
            else -> false
        }
    }

}