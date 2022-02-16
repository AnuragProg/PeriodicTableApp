package com.example.periodictableapp.listedelements

import android.os.Bundle
import android.provider.Settings
import android.util.Log
import android.view.*
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
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
    private lateinit var adapter : ListedElementsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
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

        adapter = ListedElementsAdapter()
        val recyclerView : RecyclerView = view.findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        recyclerView.adapter = adapter
        adapter.submitList(allElements)

    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.app_bar_menu, menu)

        val custom_menu = menu.findItem(R.id.search_bar)
        val search_view = custom_menu?.actionView as SearchView
        search_view.queryHint = "Query Hint"

        search_view.setOnQueryTextListener( object : SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                Toast.makeText(requireContext(), "onQueryTextSubmit called", Toast.LENGTH_SHORT).show()
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                val listedElements = allElements.filter{ newText.toString().lowercase() in it.name.lowercase()}
                adapter.submitList(listedElements)
                return true
            }

        })

    }


}