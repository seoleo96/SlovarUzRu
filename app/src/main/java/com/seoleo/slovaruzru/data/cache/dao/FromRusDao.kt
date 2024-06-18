package com.seoleo.slovaruzru.data.cache.dao

import androidx.room.Dao
import androidx.room.Query
import com.seoleo.slovaruzru.data.cache.entity.FromRusEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface FromRusDao {

    @Query("SELECT * FROM from_rus")
    suspend fun getAll(): List<FromRusEntity>

    @Query("SELECT * FROM from_rus")
    fun getAllFlow(): Flow<List<FromRusEntity>>
}