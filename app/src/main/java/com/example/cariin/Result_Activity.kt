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
    private lateinit var recommendationRV:RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_result)

        // Menyembunyikan navigation bar
        window.insetsController?.let {
            it.hide(WindowInsets.Type.navigationBars())
            it.systemBarsBehavior = WindowInsetsController.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE
        }

        recommendationRV = findViewById(R.id.recommendationRV)
        recommendationRV.layoutManager = LinearLayoutManager(this)

        val recommendations = listOf(
            Recommendation("Kuta Beach", "Kuta, Badung Regency, Bali"),
            Recommendation("Pandawa Beach ", "Bali"),
            Recommendation("Balangan Beach", "South Kuta, Badung Regency, Bali"),
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