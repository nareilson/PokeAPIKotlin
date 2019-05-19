package com.example.mykotlinaplication

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.navigation.NavHost
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment


class MyItemRecyclerViewAdapter(var pokers: ArrayList<ResultPoker>, var contexto: Context) :
    RecyclerView.Adapter<MyItemRecyclerViewAdapter.ViewHolder>() {


    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {

        val view = LayoutInflater.from(p0.context).inflate(R.layout.fragment_item, p0, false)
        return ViewHolder(view)


    }

    override fun getItemCount(): Int {
        return pokers.size
    }

    override fun onBindViewHolder(p0: ViewHolder, p1: Int) {

        p0.txtView.text = pokers[p1].name
        p0.bind()
        p0.setItemClick(object : itemClick {

            override fun onClick(view: View, position: Int) {


                Navigation.findNavController(view).navigate(R.id.action_itemFragment_to_descricaoPokeFragment)
                Toast.makeText(contexto, "Click"+pokers[p1].name, Toast.LENGTH_LONG).show()
            }
        })
    }


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener{
        private var clickListener: itemClick? = null
        val txtView: TextView = itemView.findViewById(R.id.text_pokerName)

        fun bind() {
            itemView.setOnClickListener(this)
        }

        fun setItemClick(itemClick: itemClick) {
            this.clickListener = itemClick
        }

        override fun onClick(v: View?) {
            if (v != null) {

                clickListener?.onClick(v, adapterPosition)
            }
        }


    }
}
