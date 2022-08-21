package com.problemsolver.myorder.app.presentation.CustomerOrderCheck

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CustomerOrderCheckViewModel @Inject constructor(
) : ViewModel() {


    private var _isVisible = mutableStateOf(false)
    val isVisible : State<Boolean> = _isVisible

    fun onDemandClick() {
        _isVisible.value = true
    }

    fun onCancel() {
        _isVisible.value = false
    }
}