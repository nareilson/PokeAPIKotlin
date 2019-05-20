package com.example.mykotlinaplication.Activity

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.mykotlinaplication.R
import kotlinx.android.synthetic.main.fragment_descricao_poke.*


class DescricaoPokeFragment : Fragment() {

    lateinit var name:TextView
    var namePoker:String?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var bundle = arguments
        if(bundle?.get("namePoke")!=null){
            this.namePoker =bundle.getString("namePoke")
        }

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view:View = inflater.inflate(R.layout.fragment_descricao_poke, container, false)
        name = view.findViewById(R.id.textViewNameDescricao)
        name.text = namePoker

        return view
    }

}

