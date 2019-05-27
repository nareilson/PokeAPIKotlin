package com.example.mykotlinaplication.Activity

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.mykotlinaplication.R
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.subjects.PublishSubject
import kotlinx.android.synthetic.main.fragment_teste.*


class TesteFragment : Fragment() {
    val text: TextView? = null
    val obs = PublishSubject.create<String>()
    val dispose = CompositeDisposable()
    var cont = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_teste, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        text?.findViewById<TextView>(R.id.textViewTeste)
        dispose.add(
            obs.subscribe({ t -> textViewTeste.text = t }, { e -> textViewTeste.text = "erro" })
        )

        buttonTeste.setOnClickListener {
            obs.onNext("Mensagem ${cont++}")
        if(cont == 10){
            obs.onComplete()
        }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        dispose.clear()
    }

}

