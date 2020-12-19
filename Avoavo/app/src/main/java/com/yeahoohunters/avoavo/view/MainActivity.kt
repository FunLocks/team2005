package com.yeahoohunters.avoavo.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.yeahoohunters.avoavo.R
import android.Manifest
import android.annotation.SuppressLint
import android.os.RemoteException
import android.util.Log
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import kotlinx.android.synthetic.main.fragment_forecast.view.*
import org.altbeacon.beacon.*
import permissions.dispatcher.*
import java.sql.Date
import java.text.SimpleDateFormat


@RuntimePermissions
class MainActivity : AppCompatActivity(), BeaconConsumer {

    private val UNIQUE_ID: String? = "iBeacon"
    private val UUID: String? = null
    private val MAJOR: String? = null
    private val MINOR: String? = null

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

        val toolbar: Toolbar = findViewById(R.id.toolbar)
        //toolbar.setNavigationIcon(R.drawable.ic_fun_locks_icon4)
        setSupportActionBar(toolbar)

        beaconManager = BeaconManager.getInstanceForApplication(this)
        beaconManager.isRegionStatePersistenceEnabled = false
        beaconManager.foregroundBetweenScanPeriod = 320000 // アプリをつけている時の時間間隔
        beaconManager.backgroundBetweenScanPeriod = 0
        beaconManager.backgroundScanPeriod = 280000 //　バックでの（アプリをつけた時の時間間隔）
        beaconManager.beaconParsers.add(BeaconParser().setBeaconLayout(IBEACON_FORMAT))
        startScanWithPermissionCheck()
    }

    override fun onDestroy() {
        super.onDestroy()
        /**
         * altbeacon終了
         */
        stopScan()
        beaconManager.unbind(this)
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
                Log.d("didEnterRegion", "Enter Region")
            }

            /**
             * ビーコンの範囲内から出た時の処理
             */
            override fun didExitRegion(region: Region?) {
                Log.d("didExitRegion", "Exit Region")
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
            for (beacon in beacons) {
                Log.d(
                    "beaconInfo", "UUID:${beacon.id1}\n" +
                            ", TimeStamp（最終観測時刻）: ${convertTimeStamp(beacon.lastCycleDetectionTimestamp)}\n"
                )

                /**
                 * POST処理
                 */
                //TODO:ここにPOSTの処理を書いていく
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

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
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