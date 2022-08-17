package com.example.lab_5

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Build
import com.example.lab_5.data.RestaurantDetails
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.app.ActivityCompat
import com.google.android.material.snackbar.Snackbar

class DetailsActivity : AppCompatActivity() {
    private lateinit var restaurantName: TextView
    private lateinit var restaurantAddress: TextView
    private lateinit var restaurantSchedule: TextView
    private lateinit var rootLayout: ConstraintLayout
    private lateinit var camera: Button
    private lateinit var buttonCall:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)
        // Starting the variables
        restaurantName = findViewById(R.id.txtView_details_RestaurantName)
        restaurantAddress = findViewById(R.id.txtView_details_RestaurantAddress)
        restaurantSchedule = findViewById(R.id.txtView_details_RestaurantSchedule)
        camera = findViewById(R.id.btn_details_startVisit)
        buttonCall = findViewById(R.id.btn_detailsActivity_call)
        rootLayout = findViewById(R.id.constraintLayout_detailsActivity_root)
        val restaurant: RestaurantDetails = intent.getSerializableExtra("EXTRA_RESTAURANT") as RestaurantDetails

        // Setting the values in the TextView
        restaurantName.text = "${restaurant.restaurantNameData}"
        restaurantAddress.text = "${restaurant.restaurantAddressData}"
        restaurantSchedule.text = "${restaurant.restaurantScheduleData}"


        initListeners()
    }

    private fun hasCameraPermission() =
        ActivityCompat.checkSelfPermission(this, Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED

    private fun checkCameraPermission() {
        if (!hasCameraPermission()) {
            checkRequestRationale(Manifest.permission.CAMERA)
        } else {
            Toast.makeText(this, "Permiso otorgado, abrir camara", Toast.LENGTH_LONG).show()
        }
    }

    private fun checkRequestRationale(permission:String) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            // Verificamos si debemos mostrar algun mensale racional
            if (shouldShowRequestPermissionRationale(permission)) {

                // En mi caso, lo mostraré en un SnackBar. Asi crean uno básico
                Snackbar.make(
                    rootLayout,
                    "Acceso a cámara es necesario para poder tomar fotos",
                    Snackbar.LENGTH_INDEFINITE
                )
                // Así pueden asignarle una acción (no es obligatorio, pero para nuestro caso sí lo será)
                .setAction("Ok"){
                    // Método a ejecutar al apachar el botón del snackbar
                    ActivityCompat.requestPermissions(this, arrayOf(permission),0)
                }
                // Y por último, lo deben mostrar
                .show()
            } else {
                ActivityCompat.requestPermissions(this, arrayOf(permission),0)
            }
        }
    }

    private fun requestCameraPermission() {
        ActivityCompat.requestPermissions(
            this, // Siempre deben poner el contexto del activity
            arrayOf(Manifest.permission.CAMERA), // La lista con 1 o mas permisos a solicitar
            0 // Codigo que usan en onRequestPermissionsResult
        )
    }


    fun initListeners(){
        camera.setOnClickListener {
            checkCameraPermission()
        }
        buttonCall.setOnClickListener{
            val phoneNum = "+50255544360"
            val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:$phoneNum"))
            startActivity(intent)
        }
    }
}