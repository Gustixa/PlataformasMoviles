package com.samuel.lab_10.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.request.CachePolicy
import coil.transform.CircleCropTransformation
import com.samuel.lab_10.R
import com.samuel.lab_10.dataSource.model.Character

class CharacterAdapter(
    private val dataSet: MutableList<Character>,
    private val listener: RecyclerViewCharactersEvents
) : RecyclerView.Adapter<CharacterAdapter.ViewHolder>() {

    class ViewHolder(
        private val view: View,
        private val listener: RecyclerViewCharactersEvents
    ) : RecyclerView.ViewHolder(view) {

        private val layoutCharacter: ConstraintLayout = view.findViewById(R.id.layout_recyclerItemCharacter_itemCharacter)
        private val imageCharacter: ImageView = view.findViewById(R.id.img_recyclerItemCharacter_itemCharacter)
        private val textName: TextView = view.findViewById(R.id.txt_recyclerItemCharacater_itemCharacter_name)
        private val textSpecies: TextView = view.findViewById(R.id.txt_recyclerItemCharacter_itemCharacter_species)
        private val textStatus: TextView = view.findViewById(R.id.txt_recyclerItemCharacter_itemCharacter_status)

        fun setData(character: Character) {
            character.apply {
                imageCharacter.load(character.image) {
                    placeholder(R.drawable.ic_downloading)
                    transformations(CircleCropTransformation())
                    error(R.drawable.ic_error)
                    memoryCachePolicy(CachePolicy.DISABLED)
                }
                textName.text = name
                textSpecies.text = species
                textStatus.text = status
            }
            layoutCharacter.setOnClickListener {
                listener.onItemClicked(character)

            }
        }

    }

    interface RecyclerViewCharactersEvents {
        fun onItemClicked(character: Character)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.recycler_item_character, parent, false)

        return ViewHolder(view, listener)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.setData(dataSet[position])
    }

    override fun getItemCount() = dataSet.size

}