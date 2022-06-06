package com.traveloka.bestpriceapp.ui.product.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ProductViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is Product Fragment"
    }
    val text: LiveData<String> = _text
}