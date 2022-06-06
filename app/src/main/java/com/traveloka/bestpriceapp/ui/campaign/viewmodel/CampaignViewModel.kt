package com.traveloka.bestpriceapp.ui.campaign.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CampaignViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is Campaign Fragment"
    }
    val text: LiveData<String> = _text
}