package com.example.historicheros

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_library_marker.*

class GalleryMarkerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gallery_marker)
        //Activating ActionBar Title and Back button icon
        supportActionBar?.title = "info"
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        //List for pictures
        val urlList : ArrayList<String> = ArrayList()
        urlList.add("https://www.nationalgallery.ie/sites/default/files/styles/content_hero/public/2017-05/view-through-room11-towards-room10-1936web.jpg?itok=gmChRx2q&cache-buster=9fbc470775&coords_hash=6757ace311")
        urlList.add("https://i2-prod.dublinlive.ie/incoming/article21669851.ece/ALTERNATES/s1200c/0_National-Gallery-of-Ireland-Dublin.jpg")
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