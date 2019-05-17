package com.example.mykotlinaplication.Activity

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.mykotlinaplication.R
import kotlinx.android.synthetic.main.fragment_primeiro.*



class PrimeiroFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_primeiro, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
       buttonOK.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_primeiroFragment))

    }
}
