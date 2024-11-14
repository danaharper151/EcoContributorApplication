package com.example.ecocontributorapplication.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HomeViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This home screen will have a search bar and links to other menu items."
    }
    val text: LiveData<String> = _text
}