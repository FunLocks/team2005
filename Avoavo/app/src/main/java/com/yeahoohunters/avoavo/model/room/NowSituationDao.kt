package com.yeahoohunters.avoavo.model.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.yeahoohunters.avoavo.model.api.responce.NowSituation.Congestion

@Dao
interface NowSituationDao {
    @Insert
    fun insertNowSituationItem(vararg item: Congestion)

    @Query("select * from now_situation")
    fun getNowSituation(): Congestion

    @Query("delete from now_situation")
    fun deleteNowSituation()
}