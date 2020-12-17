package com.yeahoohunters.avoavo.model.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.yeahoohunters.avoavo.model.api.responce.NowSituation
import com.yeahoohunters.avoavo.model.api.responce.NowSituation.Congection

@Database(entities = [Congection::class], version = 2)
abstract class NowSituationDatabase : RoomDatabase(){
    abstract fun nowSituationDao(): NowSituationDao

    companion object{
        @Volatile
        private var INSTANCE: NowSituationDatabase? = null

        fun getDatabase(context: Context): NowSituationDatabase{
            var tmpInstance = INSTANCE
            if(tmpInstance != null){
                return tmpInstance
            }
            synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    NowSituationDatabase::class.java,
                    "nowsituation"
                ).fallbackToDestructiveMigration().build()
                INSTANCE = instance
                return instance
            }
        }
    }
}