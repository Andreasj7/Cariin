package com.example.cariin

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.Spinner
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.cariin.database.tempDB
import com.google.android.material.textview.MaterialTextView

class TipeRekreasiActivity : AppCompatActivity() {
    private var tipePanorama = tempDB.selectedPanorama
    private lateinit var hintTipeRekreasiEt: MaterialTextView;
    private lateinit var rekreasiSpinner: Spinner;
    private var isInitialSelection = true
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_tipe_rekreasi)

        hintTipeRekreasiEt = findViewById(R.id.hintTipeRekreasiEt)
        rekreasiSpinner = findViewById(R.id.rekreasiSpinner)

        Log.d("TipeRekreasiActivity", "Selected Panorama: ${tipePanorama!!.getTipeRekreasi()}")

        val listTipeRekreasi = tipePanorama!!.getTipeRekreasi()

        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, listTipeRekreasi)

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        rekreasiSpinner.adapter = adapter

        rekreasiSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long) {
                if (isInitialSelection) {
                    isInitialSelection = false
                } else {
                    Toast.makeText(
                        this@TipeRekreasiActivity,
                        "Selected: ${listTipeRekreasi[position]}",
                        Toast.LENGTH_SHORT
                    ).show()
//                    tempDB.selectedRekreasi = listTipeRekreasi[position]
                    val intent = Intent(this@TipeRekreasiActivity, Result_Activity::class.java)
                    startActivity(intent)
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