package com.example.myscheduler

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import io.realm.OrderedRealmCollection
import io.realm.Realm
import io.realm.RealmRecyclerViewAdapter
import java.text.DateFormat

class ScheduleAdapter(data: OrderedRealmCollection<Schedule>) :
 //RealmModelインターフェース、憑依したい項目を取得、2番目はセルに表示するビューを保持
    RealmRecyclerViewAdapter<Schedule, ScheduleAdapter.ViewHolder>(data,true){

    private var listener: ((Long?) -> Unit)? =null
    //Long値を引数に戻り値はない（＝Unit）Null許容型ー＞後から値を設定する

    fun setOnItemClicklistener(listener:(Long?)-> Unit){
        this.listener = listener
    }


    init{
        setHasStableIds(true)
    }

    class ViewHolder(cell: View) : RecyclerView.ViewHolder(cell){
        val date: TextView = cell.findViewById(android.R.id.text1)
        val title: TextView = cell.findViewById(android.R.id.text2)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ScheduleAdapter.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(android.R.layout.simple_list_item_2, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val schedule :Schedule? = getItem(position)
        holder.date.text = android.text.format.DateFormat.format("yyyy//MM/dd", schedule?.date)
        holder.title.text = schedule?.title

        holder.itemView.setOnClickListener{
            listener?.invoke(schedule?.id)
        }
    }

    override fun getItemId(position: Int): Long {
        return getItem(position)?.id ?:0
    }
}