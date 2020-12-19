package com.yeahoohunters.avoavo.model.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.yeahoohunters.avoavo.model.api.responce.Favorite.FavCongection

@Dao
interface FavoriteDao {
    @Insert
    fun insertFavoriteItem(vararg item: FavCongection)

    @Query("select * from favorite")
    fun getNowSituation(): List<FavCongection>

    @Query("select * from favorite where time=:time")
    fun getNowSituationItem(time: Int): FavCongection

    @Query("delete from favorite")
    fun deleteNowSituation()
}