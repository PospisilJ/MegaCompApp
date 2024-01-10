package com.utb.megacompapp.ui.about_app

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class AboutAppViewModel : ViewModel() {

    var heartCount: Int = 0

    private val _text = MutableLiveData<String>().apply {
//        value = ""
        heartCount
    }
    val text: LiveData<String> = _text
}