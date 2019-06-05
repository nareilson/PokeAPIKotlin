package com.example.mykotlinaplication

import android.annotation.SuppressLint
import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import io.reactivex.internal.operators.observable.ObservableJust
import kotlinx.android.synthetic.main.fragment_fragmen_rx2.*
import kotlin.collections.ArrayList
import org.reactivestreams.Subscriber as Subscriber1


class FragmenRX2 : Fragment() {
    var txtView: TextView? = null

    fun getNameList(): ArrayList<String> {
        var lista = ArrayList<String>()
        lista.add("111")
        lista.add("222")
        return lista
    }

    fun getName(): ObservableJust<ArrayList<String>> {
        return ObservableJust(getNameList())
    }


    @SuppressLint("CheckResult")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        var inf = inflater.inflate(R.layout.fragment_fragmen_rx2, container, false)
        txtView = inf.findViewById(R.id.txt_rx_teste)


        getName().subscribe(
            { onNext -> txtView?.text = onNext[0]},
            { onError -> Log.e("ERRO", onError.message) })

        return inf
    }

}
