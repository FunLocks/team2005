package com.yeahoohunters.avoavo.view

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.yeahoohunters.avoavo.R
import com.yeahoohunters.avoavo.model.api.responce.Favorite
import com.yeahoohunters.avoavo.model.room.FavoriteDatabase
import com.yeahoohunters.avoavo.repository.FavoriteRepository
import kotlinx.coroutines.*

class MyplaceDetailFragment : Fragment() {
    lateinit var localFavoriteList: List<Favorite.FavCongection>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_myplace_detail, container, false)

        var locationId = arguments?.getInt("key")

        if(locationId == null) locationId = 1

        val favoriteDao = activity?.application?.let { FavoriteDatabase.getDatabase(it).favoriteDao() }
        val favoriteRepository = favoriteDao?.let { FavoriteRepository(it) }
        val scope = CoroutineScope(Job() + Dispatchers.Main)
        if (favoriteRepository != null) scope.launch(Dispatchers.Main) {
            async(Dispatchers.IO) {
                favoriteRepository.getRemoteNowSituationList(locationId)
            }.await()
                .let {
                    Log.d("FavoriteApiResult", "location_id = ${locationId}\n" + it.toString())

                    if (it.isNotEmpty()) {
                        favoriteRepository.deleteLocalFavoriteList()
                        for (remoteFavorite in it) {
                            favoriteRepository.insertLocalFavoriteItem(remoteFavorite)
                            Log.d("InsertFavoriteItem", remoteFavorite.toString())
                        }
                    }

                    localFavoriteList = withContext(Dispatchers.IO) { favoriteRepository.getLocalFavoriteList() }
                    for (item in localFavoriteList) {
                        Log.d("listFavoriteItem", item.toString())
                    }
                }

        }

        return view
    }
}