package com.example.myscheduler

import android.app.Application
import io.realm.Realm

class MySchedulerApplication : Application(){ //Applicationクラスの継承＝起動時の動作
    override fun onCreate() {
        super.onCreate()
        Realm.init(this)//初期化
    }
}