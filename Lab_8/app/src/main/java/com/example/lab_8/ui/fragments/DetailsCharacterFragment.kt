package com.example.lab_8.ui.fragments

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import coil.load
import coil.request.CachePolicy
import coil.transform.CircleCropTransformation
import com.example.lab_8.R
import com.example.lab_8.dataSource.api.RetrofitInstance
import com.example.lab_8.dataSource.model.CurrencyCharacter
import com.google.android.material.appbar.MaterialToolbar
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DetailsCharacterFragment : Fragment(R.layout.fragment_details_character) {

    private val args: DetailsCharacterFragmentArgs by navArgs()
    private lateinit var txtName: TextView
    private lateinit var txtSpecies: TextView
    private lateinit var txtGender: TextView
    private lateinit var txtStatus: TextView
    private lateinit var txtOrigin: TextView
    private lateinit var txtEpisodes: TextView
    private lateinit var imageCharacter: ImageView
    private lateinit var toolbar: MaterialToolbar


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.apply {
            txtName = findViewById(R.id.text_characterDetails_name)
            txtSpecies = findViewById(R.id.text_characterDetails_species)
            txtGender = findViewById(R.id.text_characterDetails_gender)
            txtStatus = findViewById(R.id.text_characterDetails_status)
            txtOrigin = findViewById(R.id.text_characterDetails_origin)
            txtEpisodes = findViewById(R.id.text_characterDetails_episodes)
            imageCharacter = findViewById(R.id.imgView_fragmetnDetailsCharacter_characterImage)
            toolbar = findViewById(R.id.toolbar_characterDetails)
        }

        setToolbar()
        getCharacter()
    }

    private fun setToolbar() {
        val navController = findNavController()
        val appbarConfig = AppBarConfiguration(navController.graph)

        toolbar.setupWithNavController(navController, appbarConfig)
    }

    private fun getCharacter() {
        RetrofitInstance.api.getCharacterByID(args.id).enqueue(object: Callback<CurrencyCharacter> {
            override fun onResponse(call: Call<CurrencyCharacter>, response: Response<CurrencyCharacter>) {
                if (response.isSuccessful && response.body() != null) {
                    setData(response.body()!!)
                }
            }

            override fun onFailure(call: Call<CurrencyCharacter>, t: Throwable) {
                Toast.makeText(requireContext(), getString(R.string.error_fetching), Toast.LENGTH_LONG).show()
            }

        })
    }

    private fun setData(character: CurrencyCharacter) {
        character.apply {
            txtName.text = name
            txtSpecies.text = species
            txtStatus.text = status
            txtGender.text = gender
            txtOrigin.text = origin.name
            txtEpisodes.text = episode.size.toString()
            imageCharacter.load(image) {
                placeholder(R.drawable.ic_baseline_download_24)
                transformations(CircleCropTransformation())
                error(R.drawable.ic_baseline_error_outline_24)
                memoryCachePolicy(CachePolicy.ENABLED)
            }
        }
    }

}