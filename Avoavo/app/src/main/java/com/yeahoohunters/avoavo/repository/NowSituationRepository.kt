package com.yeahoohunters.avoavo.repository

import com.yeahoohunters.avoavo.model.Params
import com.yeahoohunters.avoavo.model.api.Interface
import com.yeahoohunters.avoavo.model.api.responce.NowSituation.Congection
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

    suspend fun getRemoteNowSituationList(): List<Congection> {
        var nowSituationList: List<Congection> = listOf<Congection>()
        withContext(IO) {
            try {
                val response = nowSituationService.listNowSituation().execute().body()
                if (response != null) {
                    nowSituationList = response.congection
                }
            } catch (e: IOException) {
                e.printStackTrace()
            }
        }

        return nowSituationList
    }
}