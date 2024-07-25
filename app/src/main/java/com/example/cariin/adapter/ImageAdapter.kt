package com.example.cariin.adapter

import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.example.cariin.R
import android.view.LayoutInflater
import java.lang.Runnable


class ImageAdapter(private val imageList: ArrayList<Int> , private val viewPager2: ViewPager2)
    : RecyclerView.Adapter<ImageAdapter.ImageViweHolder>() {

    class ImageViweHolder(itemView:View) : RecyclerView.ViewHolder(itemView) {
        val imageView : ImageView = itemView.findViewById(R.id.imageView)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViweHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.image_containner,parent,false)
        return ImageViweHolder(view)
    }

    override fun getItemCount(): Int {
        return imageList.size
    }

    override fun onBindViewHolder(holder: ImageViweHolder, position: Int) {
        holder.imageView.setImageResource(imageList[position])

        if (position == imageList.size - 1){
            viewPager2.post(runnable)
        }
    }

    private val runnable = Runnable {
        imageList.addAll(imageList)
        notifyDataSetChanged()
    }
}