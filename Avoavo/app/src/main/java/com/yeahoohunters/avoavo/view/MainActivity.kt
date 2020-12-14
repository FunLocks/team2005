package com.yeahoohunters.avoavo.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.yeahoohunters.avoavo.R

class MainActivity : AppCompatActivity(){
    private val navListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navi_home -> {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.frameLayout, HomeFragment())
                    .commit()
                return@OnNavigationItemSelectedListener true
            }
            R.id.navi_graph -> {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.frameLayout, GraphFragment())
                    .commit()
                return@OnNavigationItemSelectedListener true
            }
            R.id.navi_myplace -> {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.frameLayout, MyplaceFragment())
                    .commit()
                return@OnNavigationItemSelectedListener true
            }
            R.id.navi_forecast -> {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.frameLayout, ForecastFragment())
                    .commit()
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val navigation: BottomNavigationView = findViewById(R.id.navigation)
        navigation.setOnNavigationItemSelectedListener(navListener)

        supportFragmentManager.beginTransaction()
            .replace(R.id.frameLayout, HomeFragment())
            .commit()
    }
}