package com.yeahoohunters.avoavo.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.yeahoohunters.avoavo.R
import android.app.job.JobInfo
import android.app.job.JobScheduler
import android.content.ComponentName
import android.content.Context
import android.util.Log
import android.widget.Button
import android.widget.Toast
import com.yeahoohunters.avoavo.back.MJobService

class MainActivity : AppCompatActivity(){
    private val JOB_ID : Int = 100
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

    private lateinit var JobScheduler : JobScheduler
    private lateinit var JobInfo : JobInfo

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val navigation: BottomNavigationView = findViewById(R.id.navigation)
        navigation.setOnNavigationItemSelectedListener(navListener)

        var cn = ComponentName(this, MJobService::class.java)
        var builder: JobInfo.Builder = android.app.job.JobInfo.Builder(JOB_ID, cn)
        builder.setPeriodic(50) // ms 15分以下で設定はできないらしい
                .setRequiredNetworkType(android.app.job.JobInfo.NETWORK_TYPE_ANY)
                .setPersisted(true)
        JobInfo = builder.build()
        JobScheduler = getSystemService(Context.JOB_SCHEDULER_SERVICE) as JobScheduler

        supportFragmentManager.beginTransaction()
            .replace(R.id.frameLayout, HomeFragment())
            .commit()
    }
}