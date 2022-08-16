
package com.example.lab_5
import com.example.lab_5.data.RestaurantDetails
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.net.Uri
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.button.MaterialButton


class WidgetActivity : AppCompatActivity() {
    private lateinit var btntoasMessageWidget: MaterialButton
    private lateinit var txtRestaurantName: TextView
    private lateinit var txtRestaurantAddres: TextView
    private lateinit var txtRestaurantSchedule: TextView
    private lateinit var btnDetails: Button
    private lateinit var btnLocationRestaurant: ImageButton
    private lateinit var btnDownLoads: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_widget)

        btntoasMessageWidget = findViewById(R.id.btn_toastMessage_widget)
        btnDetails = findViewById(R.id.btn_widget_RestauranteName_Details)
        txtRestaurantName = findViewById(R.id.txt_widget_RestaurantName)
        txtRestaurantAddres = findViewById(R.id.txt_widget_RestaurantLocation)
        txtRestaurantSchedule = findViewById(R.id.txt_widget_RestaurantSchedule)
        btnLocationRestaurant = findViewById(R.id.ImageBtn_widgetActivity_LocationRestaurant)
        btnDownLoads = findViewById(R.id.btn_widget_download)
        setListeners()
    }

    private fun setListeners(){
        btntoasMessageWidget.setOnClickListener{
            Toast.makeText(this, "Josúe Samuel Argueta Hernández", Toast.LENGTH_LONG).show()
        }
        btnDetails.setOnClickListener{
            val restaurantInformation = RestaurantDetails(
                restaurantNameData = txtRestaurantName.text.toString(),
                restaurantAddressData = txtRestaurantAddres.text.toString(),
                restaurantScheduleData = txtRestaurantSchedule.text.toString()
            )
            val intent = Intent(this, DetailsActivity::class.java)
            intent.putExtra("EXTRA_RESTAURANT", restaurantInformation)
            startActivity(intent)
        }
        btnLocationRestaurant.setOnClickListener{
            val location ="https://www.google.com.gt/maps/place/Rincon+Suizo,+Tecp%C3%A1n,+Guatemala/@14.7975883,-91.0184021,14z/data=!4m9!1m2!2m1!1srincon+suizo!3m5!1s0x858944806c4192a9:0x8420519191eea7d!8m2!3d14.7977415!4d-90.983373!15sCgxyaW5jb24gc3Vpem9aDiIMcmluY29uIHN1aXpvkgEKcmVzdGF1cmFudA?hl=es&authuser=0"
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(location))
            startActivity(intent)
        }
        btnDownLoads.setOnClickListener{
            val appStore = "https://play.google.com/store/search?q=clash+of+clans&c=apps&hl=es"
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(appStore))
            startActivity(intent)
        }
    }
}