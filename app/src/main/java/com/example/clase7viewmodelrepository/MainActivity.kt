package com.example.clase7viewmodelrepository

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController

class MainActivity : AppCompatActivity(), TerremotoSelectedListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onTerremotoSelected(terremoto: Terremoto) {
        findNavController(R.id.fragmentContainerView).navigate(ListFragmentDirections.actionListFragmentToDetailFragment(terremoto))
    }
}