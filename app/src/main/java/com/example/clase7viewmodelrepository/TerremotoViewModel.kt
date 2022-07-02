package com.example.clase7viewmodelrepository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class TerremotoViewModel: ViewModel() {
    private val repository = Repository()
    private val mLista = MutableLiveData<MutableList<Terremoto>>()
    val lista: LiveData<MutableList<Terremoto>>
        get() = mLista

    init {
        viewModelScope.launch {
            mLista.value = repository.getTerremotos()
        }
    }
}