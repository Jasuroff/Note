package com.example.notapp.ui.saplash

import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.notapp.core.base.BaseFragment
import com.example.notapp.databinding.ScreenSplashBinding
import com.example.notapp.databinding.ScreenSplashBinding.*

class ScreenSplash: BaseFragment(){

    private val binding by lazy {inflate(layoutInflater) }
    override fun createViwe(): View {
     return binding.root
    }

    override fun onCreated() {
        Handler().postDelayed({

            findNavController().navigate(ScreenSplashDirections.actionScreenSplashToScreenHome())
        },1000)

    }

}