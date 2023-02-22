package expert.indev.slovaruzru.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey


@Entity(
    tableName = "from_rus",
)
data class FromRus(
    @PrimaryKey
    @ColumnInfo("_id")
    val _id: Int = 0,
    @ColumnInfo("word")
    val word: String,
    @ColumnInfo("definition")
    val definition: String,
)

@Entity(
    tableName = "to_rus",
)
data class ToRus(
    @PrimaryKey
    @ColumnInfo("_id")
    val _id: Int = 0,
    @ColumnInfo("word")
    val word: String,
    @ColumnInfo("definition")
    val definition: String,
)

@Entity(
    tableName = "to_rus_lat",
)
data class ToRusLat(
    @PrimaryKey
    @ColumnInfo("_id")
    val _id: Int = 0,
    @ColumnInfo("word")
    val word: String,
    @ColumnInfo("definition")
    val definition: String,
)
