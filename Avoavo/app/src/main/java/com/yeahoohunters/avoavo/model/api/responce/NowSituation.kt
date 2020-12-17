package com.yeahoohunters.avoavo.model.api.responce

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

data class NowSituation (
    val congection: List<Congection>
){
    @Entity(tableName = "now_situation")
    data class Congection(
            @PrimaryKey val location_id: String,
            val people: Int
    )
}