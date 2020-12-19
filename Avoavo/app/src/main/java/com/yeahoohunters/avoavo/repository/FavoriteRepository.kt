package com.yeahoohunters.avoavo.repository

import com.yeahoohunters.avoavo.model.Params
import com.yeahoohunters.avoavo.model.api.Interface
import com.yeahoohunters.avoavo.model.api.responce.Favorite.FavCongection
import com.yeahoohunters.avoavo.model.room.FavoriteDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.IOException

class FavoriteRepository(private val favoriteDao: FavoriteDao) {
    private val retrofit = Retrofit.Builder()
        .baseUrl(Params.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val favoriteService =
        retrofit.create(Interface.CreateFavoriteItemService::class.java)

    suspend fun getRemoteNowSituationList(locationId: Int): List<FavCongection> {
        var favoriteList: List<FavCongection> = listOf()
        withContext(Dispatchers.IO) {
            try {
                val response = favoriteService.listFavorites(locationId).execute().body()
                if (response != null) {
                    favoriteList = response.congection
                }
            } catch (e: IOException) {
                e.printStackTrace()
            }
        }

        return favoriteList
    }

    suspend fun insertLocalFavoriteItem(congection: FavCongection) = withContext(
        Dispatchers.IO
    ){ favoriteDao.insertFavoriteItem(congection) }

    suspend fun getLocalFavoriteList(): List<FavCongection> = withContext(Dispatchers.IO){ favoriteDao.getNowSituation() }

    suspend fun getLocalFavoriteItem(time: Int): FavCongection = withContext(Dispatchers.IO){ favoriteDao.getNowSituationItem(time = time) }

    suspend fun deleteLocalFavoriteList() = withContext(Dispatchers.IO){ favoriteDao.deleteNowSituation() }

}