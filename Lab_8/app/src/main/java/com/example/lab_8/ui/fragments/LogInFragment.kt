package com.example.lab_8.ui.fragments

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.datastore.core.DataStore
import com.example.lab_8.R
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import com.google.android.material.textfield.TextInputLayout
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch

class LogInFragment : AppCompatActivity() {

    private lateinit var inputEmail: TextInputLayout
    private lateinit var inputPassword: TextInputLayout
    private lateinit var buttonStart: Button

    private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "settings")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_log_in)

        inputEmail = findViewById(R.id.txtField_fragmentLogIn_emailInput)
        inputPassword = findViewById(R.id.txtField_fragmentLogIn_passwordInput)
        buttonStart = findViewById(R.id.btn_fragmentLogIn_startSession)
        //textValue = findViewById(R.id.text_dataStore_foundValue)

        setListeners()
    }

    private fun setListeners() {
        buttonStart.setOnClickListener {
            val key = inputEmail.editText!!.text.toString()
            CoroutineScope(Dispatchers.IO).launch {
                saveKeyValue(
                    key = key,
                    value = inputPassword.editText!!.text.toString()
                )

                CoroutineScope(Dispatchers.Main).launch {
                    inputEmail.editText!!.text.clear()
                    inputPassword.editText!!.text.clear()

                    Toast.makeText(
                        applicationContext,
                        "Llave '$key' guardada",
                        Toast.LENGTH_LONG
                    ).show()
                }
            }
            var savedKey:String? = "";
            CoroutineScope(Dispatchers.IO).launch {
                savedKey = getValueFromKey(key = inputEmail.editText!!.text.toString())
            }
            if(key.equals(savedKey)){
                setCurrentFragment(CharactersFragment())
            }else{
                Toast.makeText(applicationContext, "No existe el correo como tal, debe utilizar arg211024@uvg.edu,gt", Toast.LENGTH_SHORT).show()
            }
         }
    }

    private suspend fun saveKeyValue(key: String, value: String) {
        val dataStoreKey = stringPreferencesKey(key)
        dataStore.edit { settings ->
            settings[dataStoreKey] = value
        }
    }

    private suspend fun getValueFromKey(key: String): String? {
        val dataStoreKey = stringPreferencesKey(key)
        val preferences = dataStore.data.first()
        return preferences[dataStoreKey]
    }

    /**
     * Función que reemplaza el fragment actual. Si backstack porque
     * ese es el comportamiento que queremos para la vista.
     */
    private fun setCurrentFragment(fragment: Fragment) {
        supportFragmentManager.commit {
            setReorderingAllowed(true)
            addToBackStack(null) // Agregamos al backstack
            replace(R.id.fragment_container_basicToolbarActivity, fragment)
        }
    }
}
