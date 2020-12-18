package com.yeahoohunters.avoavo.model.api.responce

import androidx.room.Entity
import androidx.room.PrimaryKey

data class NowSituation (
    val congections: List<Congection>
){
    @Entity(tableName = "now_situation")
    data class Congection(
        @PrimaryKey val location_id: Int,
        val value: Int
    )
}