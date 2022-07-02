package com.example.clase7viewmodelrepository

import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

interface TerremotoAPIService {
    @GET (value = "all_month.geojson")
    suspend fun getListaTerremotosSemana(): Response<TerremotoJsonResponse>
}

private var retrofit = Retrofit.Builder()
    .baseUrl("https://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/")
    .addConverterFactory(MoshiConverterFactory.create())
    .build()

var service: TerremotoAPIService = retrofit.create(TerremotoAPIService::class.java)