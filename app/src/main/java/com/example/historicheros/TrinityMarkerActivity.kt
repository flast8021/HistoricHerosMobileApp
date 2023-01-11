package com.example.historicheros

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_library_marker.*

class TrinityMarkerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_trinity_marker)
        //Activating ActionBar Title and Back button icon
        supportActionBar?.title = "info"
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        //List for pictures
        val urlList : ArrayList<String> = ArrayList()
        urlList.add("https://www.tcd.ie/study/assets/images/country/oldlibrary.jpg")
        urlList.add("https://www.tcd.ie/Economics/assets/images/homepage/slider-research.jpg")
//Loading picture 1
        Glide.with(this)
            .load(urlList[0])
            .centerCrop()
            .into(firstImageLibrary)
//Loading picture 2
        Glide.with(this)
            .load(urlList[1])
            .centerCrop()
            .into(secondImageLibrary)

    }
    //function for back button
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        finish()
        return super.onSupportNavigateUp()
    }
}