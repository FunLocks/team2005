package com.yeahoohunters.avoavo.model.api.responce

import androidx.room.Entity

data class NowSituation (
    val congestion: Congestion
){
    @Entity(tableName = "now_situation")
    data class Congestion(
        val congestion: ArrayList<Int>
    )
}