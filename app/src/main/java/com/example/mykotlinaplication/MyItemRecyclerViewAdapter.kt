package com.example.mykotlinaplication

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView



class  MyItemRecyclerViewAdapter(var pokers: ArrayList<ResultPoker>) : RecyclerView.Adapter<MyItemRecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {

        val view = LayoutInflater.from(p0.context).inflate(R.layout.fragment_item, p0, false)
        return ViewHolder(view)


    }
    override fun getItemCount(): Int {
       return pokers.size
    }

    override fun onBindViewHolder(p0: ViewHolder, p1: Int) {

        p0.txtView.setText(pokers[p1].name)
    }




    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

            val txtView: TextView
            init {
                txtView = itemView.findViewById(R.id.text_pokerName)

        }


    }
}
