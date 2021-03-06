package com.example.happyplaces.activities

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.happyplaces.R
import com.example.happyplaces.models.HappyPlaceModel
import kotlinx.android.synthetic.main.activity_happy_place_detail.*

class HappyPlaceDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_happy_place_detail)
        var happyPlaceModel: HappyPlaceModel? = null
        if(intent.hasExtra(MainActivity.EXTRA_PLACE_DETAILS)) {
            happyPlaceModel = intent.getParcelableExtra(MainActivity.EXTRA_PLACE_DETAILS) as HappyPlaceModel?
        }
        if(happyPlaceModel!=null) {
            setSupportActionBar(toolbar_happy_place_detail)
            supportActionBar!!.setDisplayHomeAsUpEnabled(true)
            supportActionBar!!.title = happyPlaceModel.title
            toolbar_happy_place_detail.setNavigationOnClickListener{
                onBackPressed()
            }
            iv_place_image.setImageURI(Uri.parse(happyPlaceModel.image))
            tv_description.text = happyPlaceModel.description
            tv_location.text = happyPlaceModel.location
        }
        btn_view_on_map.setOnClickListener {
            val intent = Intent(this,MapActivity::class.java)
            intent.putExtra(MainActivity.EXTRA_PLACE_DETAILS,happyPlaceModel)
            startActivity(intent)
        }

    }
}