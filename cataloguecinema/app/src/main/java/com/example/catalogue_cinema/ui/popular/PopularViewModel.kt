package com.example.catalogue_cinema.ui.popular

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.catalogue_cinema.films

class PopularViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is dashboard Fragment"
    }
    private val _films = MutableLiveData<films>().apply {

    }
    val text: LiveData<String> = _text
}