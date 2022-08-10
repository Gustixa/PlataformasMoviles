package com.example.frontendbasico

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.android.material.button.MaterialButton

class WidgetActivity : AppCompatActivity() {
    private lateinit var btntoasMessageWidget: MaterialButton
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_widget)

        btntoasMessageWidget = findViewById(R.id.btn_toastMessage_widget)
        initListeners()
    }

    private fun initListeners(){
        btntoasMessageWidget.setOnClickListener{
            Toast.makeText(this, "Josúe Samuel Argueta Hernández", Toast.LENGTH_LONG).show()
        }
    }
}