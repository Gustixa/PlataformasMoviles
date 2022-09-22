package com.example.lab_8

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.appbar.MaterialToolbar

class MainActivity : AppCompatActivity() {
    private lateinit var toolBarName: MaterialToolbar
    private lateinit var navController: NavController
    private lateinit var startSessionbutton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        // Setting AppBar
        val navHostFragment = supportFragmentManager.findFragmentById(
            R.id.fragment_container_basicToolbarActivity
        )as NavHostFragment

        navController = navHostFragment.navController

        val appBarConfig = AppBarConfiguration(navController.graph)
        toolBarName = findViewById(R.id.toolbar_mainActivity)
        toolBarName.setupWithNavController(navController, appBarConfig)
        listenToNavGraphChanges()

        startSessionbutton = findViewById(R.id.btn_fragmentLogIn_startSession)
    }
/*
    private fun setListeners(){
        toolBarName.setOnMenuItemClickListener{ menuItem->
            when(menuItem.itemId){
                R.id.menu_itemAscendentSort ->{

                }
                R.id.menu_itemDescendentSort ->{

                }
                else -> false
            }


        }
    }
*/
    /**
     * Showing the tool bar to each screen
     */
    private fun listenToNavGraphChanges(){
        navController.addOnDestinationChangedListener(NavController.OnDestinationChangedListener { _, destination, _ ->
            when (destination.id) {
                R.id.logInFragment ->{
                    toolBarName.visibility = View.INVISIBLE
                }
                R.id.detailsCharacterFragment -> {
                    toolBarName.menu.findItem(R.id.menu_itemAscendentSort).isVisible = false
                    toolBarName.menu.findItem(R.id. menu_itemDescendentSort).isVisible = false
                }
                R.id.charactersFragment->{
                    toolBarName.visibility = View.VISIBLE
                    toolBarName.menu.findItem(R.id.menu_itemAscendentSort).isVisible = true
                    toolBarName.menu.findItem(R.id.menu_itemDescendentSort).isVisible = true
                }
                else -> false
            }
        })
    }
}