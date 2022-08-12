package com.example.clase7viewmodelrepository

import android.util.Log
import androidx.lifecycle.LiveData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class Repository(private val database: TerremotoDatabase) {
    private val terremotoUseCase = TerremotoUseCase()
    val terremotos: LiveData<MutableList<Terremoto>> = database.terremotoDao.getAll()

    suspend fun getTerremotos() {
        return withContext(Dispatchers.IO) {
            val call = service.getListaTerremotosSemana()
            if (call.isSuccessful) {
                val response: TerremotoJsonResponse? = call.body()
                if (response?.features?.isNotEmpty() == true) {
                    val features = response.features
                    val terremotoLista = terremotoUseCase.parseAllTerremotos(features)
                    database.terremotoDao.insertAll(terremotoLista)
                }
            } else {
                Log.i("ERROR", call.errorBody().toString())
            }
        }
    }
}