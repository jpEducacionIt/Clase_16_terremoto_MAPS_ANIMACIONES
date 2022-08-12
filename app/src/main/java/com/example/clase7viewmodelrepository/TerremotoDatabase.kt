package com.example.clase7viewmodelrepository

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Terremoto::class], version = 1)
abstract class TerremotoDatabase: RoomDatabase() {
    abstract val terremotoDao: TerremotoDao
}

private lateinit var INSTANCE: TerremotoDatabase

fun getDatabase(context: Context) : TerremotoDatabase {
    synchronized(TerremotoDatabase::class.java) {
        if(!::INSTANCE.isInitialized) {
            INSTANCE = Room.databaseBuilder(
                context.applicationContext,
                TerremotoDatabase::class.java,
                "terremotos_db"
            ).build()
        }
        return INSTANCE
    }
}

