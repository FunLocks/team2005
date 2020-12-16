package com.yeahoohunters.avoavo.model.api

import com.yeahoohunters.avoavo.model.api.responce.Favorite
import com.yeahoohunters.avoavo.model.api.responce.NowSituation
import retrofit2.http.GET
import retrofit2.Call

class Interface {
    interface CreateFavoriteItemService{
        @GET("")
        fun listFavorites(): Call<Favorite>
    }

    interface CreateNowSituationsItemService{
        @GET("now_situation")
        fun listNowSituation(): Call<NowSituation>
    }
}