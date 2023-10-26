package com.seoleo.slovaruzru.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface FromRusDao{

    @Query("SELECT * FROM from_rus")
    suspend fun getAll(): List<FromRus>

    @Query("SELECT * FROM from_rus")
    fun getAllFlow(): Flow<List<FromRus>>

    @Insert
    suspend fun insert(fromRus: FromRus)

    @Delete
    suspend fun delete(fromRus: FromRus)

    @Query("DELETE FROM from_rus")
    suspend fun deleteAll()
}