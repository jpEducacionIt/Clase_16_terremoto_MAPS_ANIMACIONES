package com.example.clase7viewmodelrepository

data class Terremoto (
    val id: String,
    val lugar: String,
    val magnitud: Double,
    val duracion: Long,
    val latitud: Double,
    val longitud: Double
)