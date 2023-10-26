package expert.indev.slovaruzru

import android.app.Application
import android.util.Log
import expert.indev.slovaruzru.data.MyDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import java.io.File
import java.io.FileOutputStream
import java.io.InputStream
import java.io.OutputStream

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        val db = MyDatabase.getDatabase(applicationContext)
        CoroutineScope(Dispatchers.IO).launch{
            db.storageDao().getAllFlow().collectLatest {
                Log.e("TAG", "onCreate: ${it.size}")
//                for (i in  it){
//
//                    Log.e("TAG", "onCreate: $i")
//                    if (i.word == "уложиться") {
//                        break
//                    }
//                }
            }
        }
    }
}