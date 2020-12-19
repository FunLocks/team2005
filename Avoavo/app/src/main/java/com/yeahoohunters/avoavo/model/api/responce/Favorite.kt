package com.yeahoohunters.avoavo.model.api.responce

import androidx.room.Entity
import androidx.room.PrimaryKey

data class Favorite (
    val congection: List<FavCongection>
){
    @Entity(tableName = "favorite")
    data class FavCongection(
        @PrimaryKey val time: Int,
        val value: Int
    )
}