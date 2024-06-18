package com.seoleo.slovaruzru.data.cache

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.seoleo.slovaruzru.data.cache.dao.FromRusDao
import com.seoleo.slovaruzru.data.cache.dao.ToRusLatDao
import com.seoleo.slovaruzru.data.cache.entity.FromRusEntity
import com.seoleo.slovaruzru.data.cache.entity.ToRusLatEntity

@Database(
    entities = [
        ToRusLatEntity::class,
        FromRusEntity::class,
    ],
    version = 1,
    exportSchema = false
)
abstract class MyDatabase : RoomDatabase() {

    abstract fun toUzbDao(): FromRusDao
    abstract fun toRusLatDao(): ToRusLatDao

    companion object {
        @Volatile
        private var INSTANCE: MyDatabase? = null
        fun getDatabase(context: Context): MyDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }

            synchronized(this) {
                val instance = Room.databaseBuilder(context, MyDatabase::class.java, "my_db.db")
                    .createFromAsset("db.db")
                    .build()
                INSTANCE = instance
                return instance
            }
        }
    }
}