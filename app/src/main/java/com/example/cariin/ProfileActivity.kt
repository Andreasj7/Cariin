package com.example.cariin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.example.cariin.databinding.ActivityProfileBinding
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize



class ProfileActivity : AppCompatActivity() {

    private lateinit var binding: ActivityProfileBinding
    private lateinit var profilePicture: ImageView
    private lateinit var profileEmail: TextView
    private lateinit var profileUsername: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Retrieve the email and username from the intent extras
        val email = intent.getStringExtra("email")
        val username = intent.getStringExtra("username")

        // Set the email and username in their respective TextViews
        binding.profileEmail.text = "Email: $email"
        binding.profileUsername.text = "Username: $username"

        // Load the profile picture using Glide or any other image loading library
        val profilePictureUrl = "https://example.com/profile_picture.jpg"

        Glide.with(this)
            .load(profilePictureUrl)
            .transition(DrawableTransitionOptions.withCrossFade())
            .placeholder(R.drawable.baseline_person_24)
            .into(binding.profilePicture)
    }
}