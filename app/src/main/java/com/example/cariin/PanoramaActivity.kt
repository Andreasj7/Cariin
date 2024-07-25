package com.example.cariin

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.cariin.database.tempDB
import com.example.cariin.models.Panorama

class PanoramaActivity : AppCompatActivity() {

    private lateinit var panoramaSpinner: Spinner
    private var isInitialSelection = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        // Set the content view before finding views
        setContentView(R.layout.activity_panorama)

        panoramaSpinner = findViewById(R.id.panoramaSpinner)

        val panoramas = arrayListOf(
            "Gunung", "Pantai", "Air Terjun"
        )

        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, panoramas)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        panoramaSpinner.adapter = adapter

        panoramaSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long) {
                if (isInitialSelection) {
                    isInitialSelection = false
                } else {
                    var tipeRekreasi = arrayListOf<String>()
                    when (position) {
                        0 -> {
                            // Gunung
                            tipeRekreasi = arrayListOf(
                                "Spot Foto", "Tracking"
                            )
                        }
                        1 -> {
                            // Pantai
                            tipeRekreasi = arrayListOf(
                                "Berenang", "Spot Foto", "Water Sports"
                            )
                        }
                        2 -> {
                            // Air Terjun
                            tipeRekreasi = arrayListOf(
                                "Berenang", "Spot Foto"
                            )
                        }
                    }
                    tempDB.selectedPanorama = Panorama(panoramas[position], tipeRekreasi)
                    Toast.makeText(this@PanoramaActivity, "Selected: ${tempDB.selectedPanorama?.name}", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>) {
                // Another interface callback
            }
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}
