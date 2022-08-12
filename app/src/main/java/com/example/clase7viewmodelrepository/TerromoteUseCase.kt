package com.example.clase7viewmodelrepository


class TerremotoUseCase {
    fun parseAllTerremotos(features: MutableList<Feature>): MutableList<Terremoto> {
        val lista = mutableListOf<Terremoto>()

        for (feature in features) {
            val id = feature.id

            val properties = feature.properties
            val magnitud = properties.mag
            val lugar = properties.place
            val duracion = properties.time

            val geometry = feature.geometry
            val longitud = geometry.longitude
            val latitud = geometry.latitude

            val terremoto = Terremoto(id, lugar, magnitud, duracion, latitud, longitud)
            lista.add(terremoto)
        }
        return lista
    }
}