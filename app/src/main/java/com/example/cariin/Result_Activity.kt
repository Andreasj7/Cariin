package com.example.cariin

import android.os.Bundle
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

        recommendationRV = findViewById(R.id.recommendationRV)
        recommendationRV.layoutManager = LinearLayoutManager(this)

        val recommendations = listOf(
            Recommendation("Place 1", "Address 1"),
            Recommendation("Place 2", "Address 2"),
            Recommendation("Place 3", "Address 3"),
            Recommendation("Place 4", "Address 4"),
            Recommendation("Place 5", "Address 5"),
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