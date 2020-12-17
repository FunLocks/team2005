package com.yeahoohunters.avoavo.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.yeahoohunters.avoavo.R

import android.Manifest
import android.annotation.SuppressLint
import android.os.RemoteException
import android.util.Log
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import org.altbeacon.beacon.*
import permissions.dispatcher.*
import java.sql.Date
import java.text.SimpleDateFormat
import kotlin.math.floor

@RuntimePermissions
class MainActivity : AppCompatActivity(), BeaconConsumer{

    private val UNIQUE_ID: String? = "iBeacon"
    private val UUID: String? = null
    private val MAJOR: String? = null
    private val MINOR: String? = null
    private lateinit var beacon_list: LinearLayout

    /**
     * 受信するビーコンの設定
     */
    private val region = Region(
            UNIQUE_ID,
            UUID?.let { Identifier.parse(it) },
            MAJOR?.let { Identifier.parse(it) },
            MINOR?.let { Identifier.parse(it) })

    private val IBEACON_FORMAT = "m:2-3=0215,i:4-19,i:20-21,i:22-23,p:24-24"
    private lateinit var beaconManager: BeaconManager


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

        beaconManager = BeaconManager.getInstanceForApplication(this)
        beaconManager.isRegionStatePersistenceEnabled = false
        beaconManager.foregroundBetweenScanPeriod = 5000
        beaconManager.beaconParsers.add(BeaconParser().setBeaconLayout(IBEACON_FORMAT))

    }

    override fun onPause() {
        super.onPause()

        /**
         * altbeacon終了
         */
        beaconManager.unbind(this)
    }


    fun onClickStop(view: View) {
        stopScan()
    }

    fun onClickReset(view: View) {
        beacon_list.removeAllViews()
    }

    @SuppressLint("SetTextI18n")
    override fun onBeaconServiceConnect() {
        /**
         * ビーコンの範囲内への入退場時の処理
         */
        beaconManager.addMonitorNotifier(object : MonitorNotifier {
            /**
             * ビーコンの範囲内に入った時の処理
             */
            override fun didEnterRegion(region: Region?) {
                Toast.makeText(applicationContext, "Enter Region", Toast.LENGTH_SHORT).show()
            }

            /**
             * ビーコンの範囲内から出た時の処理
             */
            override fun didExitRegion(region: Region?) {
                Toast.makeText(applicationContext, "Exit Region", Toast.LENGTH_SHORT).show()
            }

            /**
             * ビーコンの範囲内への入退場の変化時の処理
             */
            override fun didDetermineStateForRegion(state: Int, region: Region?) {
                Log.d("iBeacon:Determine", "Determine State$state, Region$region")
            }
        })

        /**
         * ビーコンの範囲内にいるときに継続的に行われる処理
         */
        beaconManager.addRangeNotifier { beacons, _ ->
            for(beacon in beacons) {
                val textView = TextView(this)
                textView.text =
                        "UUID（固有ID）: ${beacon.id1}\n" +
                                "Major: ${beacon.id2}\n" +
                                "Minor: ${beacon.id3}\n" +
                                "RSSI: ${beacon.rssi}\n" +
                                "Accuracy: ${floor(beacon.distance * 100) /100}m\n" +
                                "TimeStamp: ${convertTimeStamp(beacon.lastCycleDetectionTimestamp)}\n"

                beacon_list.addView(textView)
            }
        }
    }

    /**
     * Permissionを許可した際の処理
     * ビーコンのスキャンを開始
     */
    @NeedsPermission(Manifest.permission.ACCESS_FINE_LOCATION)
    fun startScan() {
        /**
         * altbeaconが開始されているかどうか
         * `beaconManager.isBound(this)`がtrue(開始されている)なら何もしない
         * `beaconManager.isBound(this)`がfalse(開始されていない)なら開始する
         */
        if (!beaconManager.isBound(this)) {
            /**
             * altbeacon開始
             */
            beaconManager.bind(this)
        }

        /**
         * Beacon情報の監視を開始
         */
        beaconManager.startMonitoringBeaconsInRegion(region)

        beaconManager.startRangingBeaconsInRegion(region)
    }

    /**
     * ビーコンのスキャンを停止
     */
    private fun stopScan() {
        try {
            /**
             * Beacon情報の監視を終了
             */
            beaconManager.stopMonitoringBeaconsInRegion(region)

            beaconManager.stopRangingBeaconsInRegion(region)
        } catch (e: RemoteException) {
            e.printStackTrace()
        }
    }

    /**
     * Permissionを許可しなかった際の処理
     */
    @OnPermissionDenied(Manifest.permission.ACCESS_FINE_LOCATION)
    fun onDefineFineLocation() {
        Toast.makeText(this, "位置情報が許可されていません", Toast.LENGTH_SHORT).show()
    }

    /**
     * Permissionを今後表示しない際の処理
     */
    @OnNeverAskAgain(Manifest.permission.ACCESS_FINE_LOCATION)
    fun onFineLocationNeverAskAgain() {
        Toast.makeText(this, "位置情報が許可されていません、設定から許可してください。", Toast.LENGTH_SHORT).show()
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        this.onRequestPermissionsResult(requestCode, grantResults)
    }

    @SuppressLint("SimpleDateFormat")
    private fun convertTimeStamp(lastTimeStamp: Long): String {
        val simpleDateFormat = SimpleDateFormat("yyyy/MM/dd kk:mm:ss")
        val date = Date(lastTimeStamp)
        return simpleDateFormat.format(date)
    }

}