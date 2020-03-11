package com.adriankuta.viewpagerdots.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.adriankuta.viewpagerdots.R
import com.adriankuta.viewpagerdots.adapters.SectionsPagerAdapter
import kotlinx.android.synthetic.main.activity_viewpager.*
import kotlinx.android.synthetic.main.toolbar.*

class ViewPagerActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_viewpager)
        setSupportActionBar(toolbar)

        val sectionsPagerAdapter =
            SectionsPagerAdapter(
                this,
                supportFragmentManager
            )

        viewPager.adapter = sectionsPagerAdapter
        tabLayout.setupWithViewPager(viewPager)
    }
}