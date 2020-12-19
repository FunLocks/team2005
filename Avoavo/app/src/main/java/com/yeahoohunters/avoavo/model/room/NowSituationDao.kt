package com.yeahoohunters.avoavo.model.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.yeahoohunters.avoavo.model.api.responce.NowSituation.Congection

@Dao
interface NowSituationDao {
    @Insert
    fun insertNowSituationItem(vararg item: Congection)

    @Query("select * from now_situation")
    fun getNowSituation(): List<Congection>

    @Query("select * from now_situation where location_id=:locationId")
    fun getNowSituationItem(locationId: Int): Congection

    @Query("delete from now_situation")
    fun deleteNowSituation()
}