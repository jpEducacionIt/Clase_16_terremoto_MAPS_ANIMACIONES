package com.example.clase7viewmodelrepository

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs


class DetailFragment : Fragment() {
    private val args: DetailFragmentArgs by navArgs()

    private lateinit var buttonMap: Button
    private lateinit var tvPlace: TextView
    private lateinit var tvMag: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val myView = inflater.inflate(R.layout.fragment_detailfragment, container, false)
        buttonMap = myView.findViewById(R.id.buttonMap)
        tvPlace = myView.findViewById(R.id.textViewPlace)
        tvMag = myView.findViewById(R.id.textViewMag)
        return myView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val selectedTerremoto = args.terremoto
        tvPlace.text = selectedTerremoto.lugar
        tvMag.text = selectedTerremoto.magnitud.toString()

        buttonMap.setOnClickListener {
            toActivityMap(selectedTerremoto)
        }
    }

    private fun toActivityMap(selectedTerremoto: Terremoto) {
        val intent = Intent(activity, MapBoxActivity::class.java)

        intent.putExtra("terremoto", selectedTerremoto)
        startActivity(intent)
    }
}