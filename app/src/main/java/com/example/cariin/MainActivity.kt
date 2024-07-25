package com.example.cariin

import android.app.ActionBar
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.MenuItem
import android.widget.AutoCompleteTextView
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.drawerlayout.widget.DrawerLayout
import androidx.viewpager2.widget.CompositePageTransformer
import androidx.viewpager2.widget.MarginPageTransformer
import androidx.viewpager2.widget.ViewPager2
import com.example.cariin.adapter.ImageAdapter
import com.google.android.material.navigation.NavigationView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import de.hdodenhof.circleimageview.CircleImageView
import kotlin.math.abs

class MainActivity : AppCompatActivity() {

    private lateinit var database: FirebaseDatabase
    private lateinit var myRef: DatabaseReference
    private lateinit var toggle : ActionBarDrawerToggle
    private lateinit var viewPager2 : ViewPager2
    private lateinit var handler : Handler
    private lateinit var adapter: ImageAdapter
    private lateinit var imageList : ArrayList<Int>
    private lateinit var findPlaceBtn : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val drawerLayout: DrawerLayout = findViewById(R.id.drawerLayout)
        val navView: NavigationView = findViewById(R.id.navigationView)
        findPlaceBtn = findViewById(R.id.findPlaceBtn)

        toggle = ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        // Initialize the Firebase Realtime Database
        database = Firebase.database
        // Create a reference to a specific node

        myRef = database.getReference("users")
        navView.setNavigationItemSelectedListener {

            when (it.itemId) {
                R.id.nav_logout -> {
                    // Perform logout action
                    FirebaseAuth.getInstance().signOut()

                    // Clear the activity stack and start Login activity as a new task
                    val intent = Intent(this, Login::class.java)
                    intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                    startActivity(intent)
                }
                R.id.nav_home -> Toast.makeText(
                    applicationContext,
                    "Clicked Home",
                    Toast.LENGTH_SHORT
                ).show()

                R.id.wishlist -> Toast.makeText(
                    applicationContext,
                    "Clicked Sync",
                    Toast.LENGTH_SHORT
                ).show()


                R.id.nav_setting -> Toast.makeText(
                    applicationContext,
                    "Clicked setting",
                    Toast.LENGTH_SHORT
                ).show()

                R.id.nav_logout -> Toast.makeText(
                    applicationContext,
                    "Clicked login",
                    Toast.LENGTH_SHORT
                ).show()
            }
            true
        }

        findPlaceBtn.setOnClickListener {
            val intent = Intent(this, QuestionActivity::class.java)
            startActivity(intent)
        }

        init()
        setUpBali()

        viewPager2.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                handler.removeCallbacks(runnable)
                handler.postDelayed(runnable, 3000)
            }
        })
    }

    private val runnable = Runnable {
        viewPager2.currentItem = viewPager2.currentItem + 1
    }

    private fun setUpBali(){
        val bali = CompositePageTransformer()
        bali.addTransformer(MarginPageTransformer(40))
        bali.addTransformer { page, position ->
            val r = 1 - abs(position)
            page.scaleY = 0.85f + r * 0.14f
        }

        viewPager2.setPageTransformer(bali)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (toggle.onOptionsItemSelected(item)) {
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    private fun init(){
        viewPager2 = findViewById(R.id.viewPager2)
        handler = Handler(Looper.myLooper()!!)
        imageList = ArrayList()

        imageList.add(R.drawable.alone)
        imageList.add(R.drawable.alone)
        imageList.add(R.drawable.alone)
        imageList.add(R.drawable.alone)
        imageList.add(R.drawable.alone)

        adapter = ImageAdapter(imageList,viewPager2)

        viewPager2.adapter = adapter
        viewPager2.offscreenPageLimit = 3
        viewPager2.clipToPadding = false
        viewPager2.clipChildren = false
        viewPager2.getChildAt(0).overScrollMode = ViewPager2.OVER_SCROLL_NEVER
    }
}