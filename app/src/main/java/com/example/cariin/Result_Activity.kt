package com.example.cariin

import android.os.Bundle
import android.view.WindowInsets
import android.view.WindowInsetsController
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.cariin.adapter.RecommendationAdapter
import com.example.cariin.models.Recommendation

class Result_Activity : AppCompatActivity() {
    private lateinit var recommendationRV: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_result)

        recommendationRV = findViewById(R.id.recommendationRV)
        recommendationRV.layoutManager = LinearLayoutManager(this)

        // Buat daftar rekomendasi pantai dengan gambar
        val recommendations = listOf(
            Recommendation("Kuta Beach", "Kuta, Badung Regency, Bali", R.drawable.bali2),
            Recommendation("Pandawa Beach", "Bali", R.drawable.bali1),
            Recommendation("Balangan Beach", "South Kuta, Badung Regency, Bali", R.drawable.bali3),
            Recommendation("Sanur Beach", "Denpasar, Bali", R.drawable.bali4),
            Recommendation("Seminyak Beach", "Seminyak, Bali", R.drawable.bali5)
        )

        val adapter = RecommendationAdapter(recommendations)
        recommendationRV.adapter = adapter

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}
