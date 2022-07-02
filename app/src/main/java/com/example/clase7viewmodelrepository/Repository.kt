package com.example.clase7viewmodelrepository

import android.util.Log
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class Repository {
    private val terremotoUseCase = TerremotoUseCase()
    suspend fun getTerremotos(): MutableList<Terremoto> {
        return withContext(Dispatchers.IO) {
            val call = service.getListaTerremotosSemana()
            var terremotoLista = mutableListOf<Terremoto>()
            if (call.isSuccessful) {
                val response: TerremotoJsonResponse? = call.body()
                if (response?.features?.isNotEmpty() == true) {
                    val features = response.features
                    terremotoLista = terremotoUseCase.parseAllTerremotos(features)
                }
            } else {
                Log.i("JUAN", call.errorBody().toString())
            }

            terremotoLista
        }
    }
}