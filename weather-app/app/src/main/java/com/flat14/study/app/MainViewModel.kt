package com.flat14.study.app

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel() {

    private val _showFAB = MutableLiveData(true)

    val showFab: LiveData<Boolean> = _showFAB

    fun showFAB(isVisible: Boolean){
        _showFAB.value = isVisible
    }

}