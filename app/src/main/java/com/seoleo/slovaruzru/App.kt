package com.seoleo.slovaruzru

import android.app.Application
import android.util.Log
import com.seoleo.slovaruzru.data.cache.MyDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class App : Application() {

    companion object {
        lateinit var db : MyDatabase
    }

    override fun onCreate() {
        super.onCreate()

        Log.d("App", "onCreate: ")
        db = MyDatabase.getDatabase(applicationContext)
    }
}