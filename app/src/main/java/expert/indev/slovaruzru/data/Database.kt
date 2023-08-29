package expert.indev.slovaruzru.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(
    entities = [
        ToRus::class,
        ToRusLat::class,
        FromRus::class,
    ],
    version = 1,
    exportSchema = false
)
abstract class MyDatabase : RoomDatabase() {

    abstract fun storageDao(): FromRusDao

    companion object {
        @Volatile
        private var INSTANCE: MyDatabase? = null
        fun getDatabase(context: Context): MyDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }

            synchronized(this) {
                val instance = Room.databaseBuilder(context,  MyDatabase::class.java, "my_db.db")
                    .createFromAsset("db.db")
                    .build()
                INSTANCE = instance
                return instance
            }
        }
    }
}