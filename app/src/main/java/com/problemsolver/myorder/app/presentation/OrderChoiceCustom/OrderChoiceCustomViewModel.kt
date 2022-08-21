package com.problemsolver.myorder.app.presentation.OrderChoiceCustom

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class OrderChoiceCustomViewModel @Inject constructor(

) :ViewModel() {

    var _todoItems = MutableLiveData(listOf<Data>())
    val todoItem : LiveData<List<Data>> = _todoItems



    fun addItem(item:Data){
        _todoItems.value=_todoItems.value!!+ listOf(item)
    }

    fun removeItem(item:Data){
        _todoItems.value=_todoItems.value!!.toMutableList().also {
            it.remove(item)
        }
    }

}