package com.example.mykotlinaplication.Activity

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.mykotlinaplication.*
import kotlinx.android.synthetic.main.fragment_item_list.*
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
                    response?.body()?.let {
                        Item.addAll(it.results)
                        vrRecycle.layoutManager = LinearLayoutManager(activity)
                        vrRecycle.adapter = MyItemRecyclerViewAdapter(Item)


                    }
                }
            }

            override fun onFailure(call: Call<ItemPoker>, t: Throwable) {
                Log.e("ERRO", "Não foi dessa vex")
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
        vrRecycle.adapter = MyItemRecyclerViewAdapter(Item)

        //vrRecycle.adapter = MyItemRecyclerViewAdapter(Item)
        return view
    }

}
