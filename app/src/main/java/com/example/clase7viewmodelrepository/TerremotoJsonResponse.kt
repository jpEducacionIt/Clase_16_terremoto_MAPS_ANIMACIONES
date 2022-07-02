package com.example.clase7viewmodelrepository

data class TerremotoJsonResponse(val features: MutableList<Feature>)

data class Feature(
    val id: String,
    val properties: Properties,
    val geometry: Geometry)

data class Geometry(val coordinates: List<Double>) {
    val longitude: Double
        get() = coordinates[0]
    val latitude: Double
        get() = coordinates[1]
}

data class Properties(
    val mag: Double,
    val time: Long,
    val place: String
)
