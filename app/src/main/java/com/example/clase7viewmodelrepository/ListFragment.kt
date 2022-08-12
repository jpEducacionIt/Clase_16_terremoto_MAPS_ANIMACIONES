package com.example.clase7viewmodelrepository

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.lang.ClassCastException

class ListFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: TerremotoAdapter
    private lateinit var progressBar: ProgressBar

    private lateinit var listener: TerremotoSelectedListener

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val myView = inflater.inflate(R.layout.fragment_list, container, false)
        recyclerView = myView.findViewById(R.id.recyclerLista)
        progressBar = myView.findViewById(R.id.progressBar)
        return myView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val viewModel: TerremotoViewModel = ViewModelProvider(this, TerremotoViewModelFactory(requireActivity().application))[TerremotoViewModel::class.java]

        recyclerView.layoutManager = LinearLayoutManager(requireActivity())
        adapter = TerremotoAdapter()
        recyclerView.adapter = adapter

        viewModel.lista.observe(viewLifecycleOwner, Observer {
            adapter.submitList(it)
        })

        viewModel.status.observe(viewLifecycleOwner, Observer {
            when (it) {
                ApiResponseStatus.LOADING -> {
                    progressBar.visibility = View.VISIBLE
                }
                ApiResponseStatus.SUCCESS -> {
                    progressBar.visibility = View.GONE
                }
                ApiResponseStatus.ERROR -> {
                    progressBar.visibility = View.GONE
                }
            }
        })

        adapter.onItemClickListener = {
            Toast.makeText(activity, it.lugar, Toast.LENGTH_SHORT).show()
            listener.onTerremotoSelected(it)
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)

        listener = try {
            context as TerremotoSelectedListener
        } catch (e: ClassCastException) {
            throw  ClassCastException("$context debe implementar el listener")
        }
    }
}
