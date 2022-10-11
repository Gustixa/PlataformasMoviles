package com.samuel.lab_10.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import androidx.room.Room
import com.samuel.lab_10.dataSource.local.DataBase
import com.samuel.lab_10.dataSource.model.CharacterData
import coil.load
import coil.request.CachePolicy
import coil.transform.CircleCropTransformation
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.textfield.TextInputLayout
import com.samuel.lab_10.R
import com.samuel.lab_10.dataSource.api.RetrofitInstance
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import com.samuel.lab_10.dataSource.local.model.Character
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import com.samuel.lab_10.dataSource.model.mapToModel

class CharacterDetailsFragment : Fragment(R.layout.fragment_character_details) {

    private val args: CharacterDetailsFragmentArgs by navArgs()
    private lateinit var txtName: TextInputLayout
    private lateinit var txtSpecies: TextInputLayout
    private lateinit var txtGender: TextInputLayout
    private lateinit var txtStatus: TextInputLayout
    private lateinit var txtOrigin: TextInputLayout
    private lateinit var txtEpisodes: TextInputLayout
    private lateinit var imageCharacter: ImageView
    private lateinit var toolbar: MaterialToolbar
    private lateinit var btnUpdate: Button
    private lateinit var database: DataBase
    private lateinit var character: Character


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.apply {
            txtName = findViewById(R.id.inputLayout_detailsCharacter_name)
            txtSpecies = findViewById(R.id.inputLayout_detailsCharacter_species)
            txtGender = findViewById(R.id.inputLayout_detailsCharacter_gender)
            txtStatus = findViewById(R.id.inputLayout_detailsCharacter_status)
            txtOrigin = findViewById(R.id.inputLayout_detailsCharacter_origin)
            txtEpisodes = findViewById(R.id.inputLayout_detailsCharacter_episodes)
            imageCharacter = findViewById(R.id.image_characterDetails)
            toolbar = findViewById(R.id.toolbar_characterDetails)
            btnUpdate = findViewById(R.id.btn_detailsCharacter_save)
        }

        database = Room.databaseBuilder(
            requireContext(),
            DataBase::class.java,
            "labDatabase"
        ).build()

        setToolbar()
        setListeners()
        getCharacter()
    }

    private fun setToolbar() {
        val navController = findNavController()
        val appbarConfig = AppBarConfiguration(navController.graph)

        toolbar.setupWithNavController(navController, appbarConfig)
    }

    private fun setListeners() {
        toolbar.setOnMenuItemClickListener { menuItem ->
            when(menuItem.itemId) {
                R.id.delete_character -> {
                    deleteCharacter()
                    true
                }

                R.id.sync_characters -> {
                    fetchCharacter()
                    true
                }

                else -> false
            }
        }
        btnUpdate.setOnClickListener {
            updateCharacter(character.copy(
                name = txtName.editText!!.text.toString(),
                species = txtSpecies.editText!!.text.toString(),
                status = txtStatus.editText!!.text.toString(),
                gender = txtGender.editText!!.text.toString(),
                origin = txtOrigin.editText!!.text.toString(),
                episodes = txtEpisodes.editText!!.text.toString().toInt(),
            ))
        }
    }

    private fun getCharacter() {
        lifecycleScope.launchWhenStarted {
            val localCharacter = database.characterDao().getCharacter(args.id)
            if (localCharacter == null) {
                Toast.makeText(requireContext(), getString(R.string.character_not_found), Toast.LENGTH_LONG).show()
                requireActivity().onBackPressed()
            } else {
                character = localCharacter
                setData()
            }
        }
    }

    private fun fetchCharacter() {
        RetrofitInstance.api.getCharacter(args.id).enqueue(object: Callback<CharacterData> {
            override fun onResponse(call: Call<CharacterData>, response: Response<CharacterData>) {
                if (response.isSuccessful && response.body() != null) {
                    character = response.body()!!.mapToModel()
                    updateCharacter(character)
                    setData()
                } else {
                    Toast.makeText(requireContext(), getString(R.string.character_not_found), Toast.LENGTH_LONG).show()
                    requireActivity().onBackPressed()
                }
            }

            override fun onFailure(call: Call<CharacterData>, t: Throwable) {
                Toast.makeText(requireContext(), getString(R.string.error_fetching), Toast.LENGTH_LONG).show()
            }

        })
    }

    private fun updateCharacter(character: Character) {
        lifecycleScope.launch {
            database.characterDao().update(character)
            Toast.makeText(requireContext(), getString(R.string.successful_update), Toast.LENGTH_LONG).show()
        }
    }

    private fun deleteCharacter() {
        lifecycleScope.launch {
            if (database.characterDao().delete(character) > 0) {
                Toast.makeText(requireContext(), getString(R.string.successful_delete), Toast.LENGTH_LONG).show()
                requireActivity().onBackPressed()
            } else {
                Toast.makeText(requireContext(), "Error eliminando personaje, inténtalo de nuevo", Toast.LENGTH_LONG).show()
            }
        }
    }

    private fun setData() {
        character.apply {
            txtName.editText!!.setText(name)
            txtSpecies.editText!!.setText(species)
            txtStatus.editText!!.setText(status)
            txtGender.editText!!.setText(gender)
            txtOrigin.editText!!.setText(origin)
            txtEpisodes.editText!!.setText(episodes.toString())
            imageCharacter.load(image) {
                placeholder(R.drawable.ic_downloading)
                transformations(CircleCropTransformation())
                error(R.drawable.ic_error)
                diskCachePolicy(CachePolicy.ENABLED)
            }
        }
    }

}