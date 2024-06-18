package com.seoleo.slovaruzru.data.cache.dao

import androidx.room.Dao
import androidx.room.Query
import com.seoleo.slovaruzru.data.cache.entity.ToRusLatEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface ToRusLatDao {

    @Query("SELECT * FROM to_rus_lat")
    suspend fun getAll(): List<ToRusLatEntity>

    @Query("SELECT * FROM to_rus_lat")
    fun getAllFlow(): Flow<List<ToRusLatEntity>>
}