package com.example.lab_6

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import com.google.android.material.bottomnavigation.BottomNavigationView


class MainActivity : AppCompatActivity() {
    private lateinit var bottomNav: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bottomNav = findViewById(R.id.bottomNavi_bottomNavActivity)
        setCurrentFragment(HomeFragment())
        setListeners()
    }

    private fun setListeners(){
        bottomNav.setOnItemSelectedListener {
            // Dependiendo el item del menu, mostramos el fragment deseado
            when(it.itemId) {
                R.id.home_fragment -> setCurrentFragment(HomeFragment())
                R.id.search_fragment -> setCurrentFragment(SearchFragment())
                R.id.yourLibrary_fragment-> setCurrentFragment(YourLibraryFragment())
            }
            true
        }
    }

    private fun setCurrentFragment(fragment: Fragment){
        supportFragmentManager.commit {
            setReorderingAllowed(true)
            //addToBackStack(null)
            replace(R.id.fragmentContainer_mainActivity_bottomNavActivity, fragment)
        }
    }
}