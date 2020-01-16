package com.example.myscheduler

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import java.util.*

//RealmObjectを継承したスケジュールクラス　＝＞　データを格納するモデル
open class Schedule : RealmObject() {
    @PrimaryKey
    var id : Long = 0
    var date: Date = Date()
    var title : String = ""
    var detail: String = ""
}