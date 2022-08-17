package com.table.periodictableapp.listedelements

import android.content.Context
import androidx.lifecycle.ViewModel
import com.table.periodictableapp.periodictable.AllElements
import com.table.periodictableapp.periodictable.Element
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class ListedElementsViewModel : ViewModel() {

    fun getPeriodicTableFromAsset(context : Context) : List<Element>{
        val jsonToString = com.table.periodictableapp.getPeriodicTableFromAsset(context)
        val gson = Gson()
        val listOfElements = object : TypeToken<AllElements>(){}.type
        val allElements : AllElements = gson.fromJson(jsonToString, listOfElements)

        return allElements.elements
    }

}