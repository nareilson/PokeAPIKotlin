package com.example.mykotlinaplication.Activity

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.mykotlinaplication.APICliente
import com.example.mykotlinaplication.R
import com.example.mykotlinaplication.Descricao.DescricaoPoker
import com.example.mykotlinaplication.RetrofitClass
import kotlinx.android.synthetic.main.fragment_descricao_poke.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class DescricaoPokeFragment : Fragment() {

    lateinit var name:TextView
    lateinit var  altura:TextView
    lateinit var peso:TextView
    var namePoker:String?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var bundle = arguments
        if(bundle?.get("namePoke")!=null){
            this.namePoker =bundle.getString("namePoke")


        }

    }

    fun getDescricao(){
        val  call:Call<DescricaoPoker> = RetrofitClass().acessar().create(APICliente::class.java).getPokemon(namePoker.toString())
        call.enqueue(object:Callback<DescricaoPoker>{
            override fun onResponse(call: Call<DescricaoPoker>, response: Response<DescricaoPoker>) {
               if(response.isSuccessful){
                   name.text = response.body()?.name
                   altura.text = response.body()?.height.toString()
                   peso.text = response.body()?.weight.toString()
               }

            }

            override fun onFailure(call: Call<DescricaoPoker>, t: Throwable) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }
        })
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view:View = inflater.inflate(R.layout.fragment_descricao_poke, container, false)
        name = view.findViewById(R.id.textViewNameDescricao)
        altura= view.findViewById(R.id.textViewPeso)
        peso = view.findViewById(R.id.textViewAltura)
        getDescricao()

        return view
    }

}

