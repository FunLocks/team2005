package com.yeahoohunters.avoavo.repository

import com.yeahoohunters.avoavo.model.Params
import com.yeahoohunters.avoavo.model.api.Interface
import com.yeahoohunters.avoavo.model.api.responce.NowSituation
import com.yeahoohunters.avoavo.model.api.responce.NowSituation.Congection
import com.yeahoohunters.avoavo.model.room.NowSituationDao
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.IOException

class NowSituationRepository (private val nowSituationDao: NowSituationDao){
    private val retrofit = Retrofit.Builder()
        .baseUrl(Params.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val nowSituationService =
        retrofit.create(Interface.CreateNowSituationsItemService::class.java)

    suspend fun getRemoteNowSituationList(): List<Congection> {
        var nowSituationList: List<Congection> = listOf()
        withContext(IO) {
            try {
                val response = nowSituationService.listNowSituation().execute().body()
                if (response != null) {
                    nowSituationList = response.congections
                }
            } catch (e: IOException) {
                e.printStackTrace()
            }
        }

        return nowSituationList
    }

    suspend fun insertLocalNowSituationItem(congection: Congection) = withContext(IO){ nowSituationDao.insertNowSituationItem(congection) }

    suspend fun getLocalNowSituationList(): List<Congection> = withContext(IO){ nowSituationDao.getNowSituation() }

    suspend fun getLocalNowSituationItem(locationId: Int): Congection = withContext(IO){ nowSituationDao.getNowSituationItem(locationId = locationId) }

    suspend fun deleteLocalNowSituationList() = withContext(IO){ nowSituationDao.deleteNowSituation() }
}