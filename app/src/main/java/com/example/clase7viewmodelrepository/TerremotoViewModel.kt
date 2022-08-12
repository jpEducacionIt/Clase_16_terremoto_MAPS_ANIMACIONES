package com.example.clase7viewmodelrepository

import android.app.Application
import android.util.Log
import androidx.lifecycle.*
import kotlinx.coroutines.launch
import java.net.UnknownHostException

class TerremotoViewModel(application: Application): AndroidViewModel(application) {
    private val database = getDatabase(application)
    private val repository = Repository(database)
    val lista = repository.terremotos

    private val mStatus = MutableLiveData<ApiResponseStatus>()
    val status: LiveData<ApiResponseStatus>
        get() = mStatus

    init {
        viewModelScope.launch {
            try {
                mStatus.value = ApiResponseStatus.LOADING
                repository.getTerremotos()
                mStatus.value = ApiResponseStatus.SUCCESS
            } catch (e: UnknownHostException) {
                mStatus.value = ApiResponseStatus.ERROR
                Log.i("ERROR", "NO HAY INTERNET")
            }
        }
    }
}