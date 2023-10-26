package com.seoleo.slovaruzru

import android.app.Application
import android.util.Log
import com.seoleo.slovaruzru.data.MyDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

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