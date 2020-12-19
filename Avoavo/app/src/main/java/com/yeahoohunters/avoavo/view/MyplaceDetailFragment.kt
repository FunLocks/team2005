package com.yeahoohunters.avoavo.view

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.yeahoohunters.avoavo.R
import com.yeahoohunters.avoavo.model.api.responce.Favorite
import com.yeahoohunters.avoavo.model.room.FavoriteDatabase
import com.yeahoohunters.avoavo.repository.FavoriteRepository
import kotlinx.coroutines.*

import com.github.mikephil.charting.charts.BarChart
import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.data.BarEntry
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet

class MyplaceDetailFragment : Fragment() {
    lateinit var localFavoriteList: List<Favorite.FavCongection>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_myplace_detail, container, false)

        var locationId = arguments?.getInt("key")

        if(locationId == null) locationId = 1

        val favoriteDao = activity?.application?.let { FavoriteDatabase.getDatabase(it).favoriteDao() }
        val favoriteRepository = favoriteDao?.let { FavoriteRepository(it) }
        val scope = CoroutineScope(Job() + Dispatchers.Main)
        if (favoriteRepository != null) scope.launch(Dispatchers.Main) {
            async(Dispatchers.IO) {
                favoriteRepository.getRemoteNowSituationList(locationId)
            }.await()
                .let {
                    Log.d("FavoriteApiResult", "location_id = ${locationId}\n" + it.toString())

                    if (it.isNotEmpty()) {
                        favoriteRepository.deleteLocalFavoriteList()
                        for (remoteFavorite in it) {
                            favoriteRepository.insertLocalFavoriteItem(remoteFavorite)
                            Log.d("InsertFavoriteItem", remoteFavorite.toString())
                        }
                    }

                    localFavoriteList = withContext(Dispatchers.IO) { favoriteRepository.getLocalFavoriteList() }
                    for (item in localFavoriteList) {
                        Log.d("listFavoriteItem", item.toString())
                    }
                }
        }
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val x = listOf<Float>(0f, 1f, 2f, 3f, 4f, 5f, 6f, 7f, 8f, 9f, 10f, 11f, 12f, 13f, 14f, 15f, 16f,17f, 18f, 19f, 20f, 21f, 22f, 23f) // People Data
        val y = listOf<Float>(1f, 1f, 1f, 1f, 1f, 1f, 2f, 1f, 20f, 32f, 30f, 73f, 64f, 67f, 14f, 56f, 13f, 68f, 54f, 12f, 7f, 2f, 0f, 1f) // People Data

        var value_list: MutableList<Float> = mutableListOf() // Time Data
        var a:List<Float>
        /*if(localFavoriteList != null){
            for (i in localFavoriteList){
                value_list.add(i.value.toFloat())
            }
           a = value_list
        }else{
            a = y
            Log.d("error","error")
        }
*/



        //①Entryにデータ格納
        var entryList1 = mutableListOf<BarEntry>()
        for (i in x.indices) {
            entryList1.add(BarEntry(x[i], y[i]))

        }

        //BarDataSetのリスト
        val barDataSets1 = mutableListOf<IBarDataSet>()
        //②DataSetにデータ格納
        val barDataSet1 = BarDataSet(entryList1, "square")
        //③DataSetのフォーマット指定
        barDataSet1.color = Color.parseColor("#7fffd4")  // グラフの色を変更
        //リストに格納
        barDataSets1.add(barDataSet1)
        //④BarDataにBarDataSet格納
        val barData1 = BarData(barDataSets1)
        //⑤BarChartにBarData格納
        val barChart1 = view.findViewById<BarChart>(R.id.barChart1Example)
        barChart1.data = barData1
        //⑥Chartのフォーマット指定
        //X軸の設定
        barChart1.xAxis.apply {
            isEnabled = true
            textColor = Color.parseColor("#000000")
        }

    }

}