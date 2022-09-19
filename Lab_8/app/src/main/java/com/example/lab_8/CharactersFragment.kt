package com.example.lab_8

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.lab_8.adapters.PlaceAdapter
import com.example.lab_8.dataBase.Character
import com.example.lab_8.dataBase.RickAndMortyDB
import com.example.lab_8.dataSource.api.RetrofitInstance
import com.example.lab_8.dataSource.model.AllAssetsResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class CharactersFragment : Fragment(R.layout.fragment_characters), PlaceAdapter.RecyclerViewCharacterClickHandler{
    private lateinit var recyclerView: RecyclerView
    private lateinit var placeList: MutableList<Character>


    override fun onViewCreated(view: View,savedInstanceState: Bundle?) {
        super.onViewCreated(view,savedInstanceState)
        // Setting AppBar



        recyclerView = view.findViewById(R.id.recycler_placeList)


        setupRecycler()

        //onOptionsItemSelected(menu)

    }

    private fun setupRecycler(){
        RetrofitInstance.api.getCharacters().enqueue(object : Callback<AllAssetsResponse>{
            override fun onResponse(
                call: Call<AllAssetsResponse>,
                response: Response<AllAssetsResponse>
            ) {
                if(response.isSuccessful){
                    println(response.body())
                }
            }

            override fun onFailure(call: Call<AllAssetsResponse>, t: Throwable) {
                println("Error")
            }

        })
        placeList = RickAndMortyDB.getCharacters()
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = PlaceAdapter(placeList, this)
    }

    override fun onCharacterClick(character: Character) {
        val action = CharactersFragmentDirections.actionCharactersFragmentToDetailsCharacterFragment(character)
        requireView().findNavController().navigate(action)
    }
}