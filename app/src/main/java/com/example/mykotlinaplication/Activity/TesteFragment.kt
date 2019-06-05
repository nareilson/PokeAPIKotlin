package com.example.mykotlinaplication.Activity

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import com.example.mykotlinaplication.R
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.subjects.PublishSubject
import kotlinx.android.synthetic.main.fragment_teste.*


class TesteFragment : Fragment() {
    val button:Button? = null
    val text:TextView?=null
    val pubSubObs = PublishSubject.create<String>()
    val dispose = CompositeDisposable()
    var cont = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return  inflater.inflate(R.layout.fragment_teste, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        button?.findViewById<Button>(R.id.buttonTeste)
        text?.findViewById<TextView>(R.id.textViewTeste)

        dispose.add(
            pubSubObs.subscribe({ t ->textViewTeste.text = t }
                ,{ e ->textViewTeste.text = "erro"}
            )
        )
        button?.setOnClickListener {
            pubSubObs.onNext("Mensagem ${cont++}")
            if(cont == 10){
                pubSubObs.onComplete()
            }}
    }

    override fun onDestroy() {
        super.onDestroy()
        dispose.clear()
    }

}

