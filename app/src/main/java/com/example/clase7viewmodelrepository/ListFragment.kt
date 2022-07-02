package com.example.clase7viewmodelrepository

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ListFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: TerremotoAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val myView = inflater.inflate(R.layout.fragment_list, container, false)
        recyclerView = myView.findViewById(R.id.recyclerLista)
        return myView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val viewModel: TerremotoViewModel = ViewModelProvider(this)[TerremotoViewModel::class.java]

        recyclerView.layoutManager = LinearLayoutManager(requireActivity())
        adapter = TerremotoAdapter()
        recyclerView.adapter = adapter

        viewModel.lista.observe(viewLifecycleOwner, Observer {
            adapter.submitList(it)
        })

        adapter.onItemClickListener = {
            Toast.makeText(activity, it.lugar, Toast.LENGTH_SHORT).show()
        }
    }
}
