package com.samuel.lab_12.viewModel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.samuel.lab_12.R
import com.samuel.lab_12.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}