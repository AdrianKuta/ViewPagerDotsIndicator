package com.adriankuta.viewpagerdots.activities

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.adriankuta.viewpagerdots.R
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.toolbar.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        viewPagerBtn.setOnClickListener {
            startActivity(Intent(this, ViewPagerActivity::class.java))
        }
        viewPager2Btn.setOnClickListener {
            startActivity(Intent(this, ViewPager2Activity::class.java))
        }
    }
}