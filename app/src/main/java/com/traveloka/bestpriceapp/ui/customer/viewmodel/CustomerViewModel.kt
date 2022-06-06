package com.traveloka.bestpriceapp.ui.customer.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CustomerViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is Customer Fragment"
    }
    val text: LiveData<String> = _text
}