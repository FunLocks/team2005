package com.yeahoohunters.avoavo.model.api

import com.yeahoohunters.avoavo.model.api.responce.Favorite
import com.yeahoohunters.avoavo.model.api.responce.NowSituation
import retrofit2.http.GET
import retrofit2.Call
import retrofit2.http.Path

class Interface {
    interface CreateFavoriteItemService{
        @GET("favorite_predict/{location_id}")
        fun listFavorites(@Path("location_id") locationId: Int): Call<Favorite>
    }

    interface CreateNowSituationsItemService{
        @GET("now_situation")
        fun listNowSituation(): Call<NowSituation>
    }
}