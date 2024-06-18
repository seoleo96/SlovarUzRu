package com.seoleo.slovaruzru.data.cache.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(
    tableName = "to_rus_lat",
)
data class ToRusLatEntity(
    @PrimaryKey
    @ColumnInfo("_id")
    val id: Int = 0,
    @ColumnInfo("word")
    val word: String?,
    @ColumnInfo("definition")
    val definition: String?,
)
