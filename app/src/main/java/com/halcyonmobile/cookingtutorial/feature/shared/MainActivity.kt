package com.halcyonmobile.cookingtutorial.feature.shared

import android.content.Intent
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.halcyonmobile.cookingtutorial.R
import com.halcyonmobile.cookingtutorial.databinding.ActivityMainBinding
import com.halcyonmobile.cookingtutorial.feature.home.DishesActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.seeDishes.setOnClickListener {
            val intent = Intent(this@MainActivity, DishesActivity::class.java)
            startActivity(intent)
        }
    }
}
