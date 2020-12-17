package com.yeahoohunters.avoavo.repository

import com.yeahoohunters.avoavo.model.Params
import com.yeahoohunters.avoavo.model.api.Interface
import com.yeahoohunters.avoavo.model.api.responce.NowSituation.Congestion
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.IOException

class NowSituationRepository {
    private val retrofit = Retrofit.Builder()
        .baseUrl(Params.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val nowSituationService =
        retrofit.create(Interface.CreateNowSituationsItemService::class.java)

    suspend fun getRemoteNowSituationList(): List<Congestion> {
        var nowSituationList: List<Congestion> = listOf()
        withContext(IO) {
            try {
                val response = nowSituationService.listNowSituation().execute().body()
                if (response != null) {
                    nowSituationList = response.congestion
                }
            } catch (e: IOException) {
                e.printStackTrace()
            }
        }

        return nowSituationList
    }
}