package com.table.periodictableapp

import android.content.Context
import java.io.IOException


private val FILENAME = "periodic_table.json"
fun getPeriodicTableFromAsset(context: Context, filename:String= FILENAME) : String?{
    val json : String
    return try{
        json = context.assets.open(filename).bufferedReader().use{ it.readText()}
        json

    }catch (ioException : IOException){
        ioException.printStackTrace()
        null
    }
}


