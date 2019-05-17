package com.example.mykotlinaplication

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView



class MyItemRecyclerViewAdapter(
    private var pokers: List<ResultPoker>
) : RecyclerView.Adapter<MyItemRecyclerViewAdapter.ViewHolder>() {
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {

        val view = LayoutInflater.from(p0.context).inflate(R.layout.fragment_item_list, p0, false)
        return ViewHolder(view)


    }
    override fun getItemCount(): Int {
       return pokers.size
    }

    override fun onBindViewHolder(p0: ViewHolder, p1: Int) {

        p0.bindView(pokers[p1])
    }




    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindView(result:ResultPoker){
            val txtView = itemView.findViewById<TextView>(R.id.text_pokerName)
            txtView.text = result.name
        }


    }
}
