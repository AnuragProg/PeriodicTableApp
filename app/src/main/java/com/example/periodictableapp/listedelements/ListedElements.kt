package com.example.periodictableapp.listedelements

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.periodictableapp.R
import com.example.periodictableapp.getPeriodicTableFromAsset
import com.example.periodictableapp.periodictable.AllElements
import com.example.periodictableapp.periodictable.Element
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken


class ListedElements : Fragment() {

    private lateinit var allElements : List<Element>
    private val listedElementsViewModel : ListedElementsViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        allElements = listedElementsViewModel.getPeriodicTableFromAsset(requireContext())
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_listed_elements, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = ListedElementsAdapter(allElements)
        var recyclerView : RecyclerView = view.findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        recyclerView.adapter = adapter

    }


}