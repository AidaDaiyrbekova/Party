package com.example.auto

import android.content.Context
import androidx.lifecycle.ViewModel
import java.util.*

class MainViewModel(val context: Context) : ViewModel() {
    //private val repository = MainRepository()

    fun loadData():String? {
        val inputStream = context.resources.openRawResource(R.raw.json)
        val scanner = Scanner(inputStream)
        val builder: StringBuilder = StringBuilder()
        while (scanner.hasNextLine()) {
            builder.append(scanner.nextLine())
        }
        return builder.toString()
    }
}