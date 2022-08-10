package com.example.frontendbasico

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    private lateinit var btnToNextActivity:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnToNextActivity = findViewById(R.id.btn_mainActivity_toNextActivity)
        initListeners()
    }

    fun initListeners(){
        btnToNextActivity.setOnClickListener{
            val intent = Intent(this, WidgetActivity::class.java)
            startActivity(intent)
        }
    }
}