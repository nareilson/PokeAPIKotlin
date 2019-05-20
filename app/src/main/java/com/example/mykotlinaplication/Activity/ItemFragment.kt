package com.example.mykotlinaplication.Activity

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.mykotlinaplication.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.ArrayList

class ItemFragment : Fragment() {

    var Item: ArrayList<ResultPoker> = ArrayList()
    lateinit var vrRecycle: RecyclerView


    fun getResult() {

        val call = RetrofitClass().acessar().create(APICliente::class.java).getPokerModel()
        call.enqueue(object : Callback<ItemPoker> {
            override fun onResponse(call: Call<ItemPoker>, response: Response<ItemPoker>) {

                if (response.isSuccessful) {
                    response.body()?.let {
                        Item.addAll(it.results)
                        vrRecycle.layoutManager = LinearLayoutManager(activity)
                        vrRecycle.adapter = MyItemRecyclerViewAdapter(Item,activity!!)


                    }
                }
            }

            override fun onFailure(call: Call<ItemPoker>, t: Throwable) {
            }

        })
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_item_list, container, false)
        vrRecycle = view.findViewById(R.id.list)
        getResult()
        vrRecycle.layoutManager = LinearLayoutManager(activity)
        vrRecycle.adapter = MyItemRecyclerViewAdapter(Item,activity!!)
        return view
    }

}
