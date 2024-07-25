package com.example.cariin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import com.example.cariin.database.tempDB
import com.example.cariin.models.Panorama

class QuestionActivity : AppCompatActivity() {

    private lateinit var questionSpinner: Spinner
    private var isInitialSelection = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_question)

        questionSpinner = findViewById(R.id.questionSpinner)

        val citiesInBali = arrayListOf(
            "Denpasar", "Kuta", "Seminyak", "Ubud", "Sanur", "Nusa Dua", "Jimbaran",
            "Canggu", "Gianyar", "Lovina", "Amed", "Padangbai", "Candidasa", "Bedugul",
            "Tabanan", "Bangli", "Karangasem", "Mengwi", "Tulamben", "Pecatu"
        )

        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, citiesInBali)

        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        // Apply the adapter to the spinner
        questionSpinner.adapter = adapter

        // Set an on item selected listener for spinner object
        questionSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long) {
                if (isInitialSelection) {
                    isInitialSelection = false
                } else {
                    tempDB.selectedCity = citiesInBali[position]
//                    val intent = Intent(this, )
//                    startActivity(intent)
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>) {
                // Another interface callback
            }
        }
    }
}
