package com.example.cariin.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.cariin.R
import com.example.cariin.models.Recommendation

class RecommendationAdapter(private val recommendations: List<Recommendation>) :
    RecyclerView.Adapter<RecommendationAdapter.RecommendationViewHolder>() {

    class RecommendationViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val recommendationNameTV: TextView = itemView.findViewById(R.id.recommendationNameTV)
        val textView4: TextView = itemView.findViewById(R.id.textView4)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecommendationViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.result_recyclerview_item, parent, false)
        return RecommendationViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecommendationViewHolder, position: Int) {
        val recommendation = recommendations[position]
        holder.recommendationNameTV.text = recommendation.getName()
        holder.textView4.text = recommendation.getAlamat()
    }

    override fun getItemCount(): Int {
        return recommendations.size
    }
}
