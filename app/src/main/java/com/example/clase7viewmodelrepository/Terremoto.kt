package com.example.clase7viewmodelrepository

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Entity(tableName = "terremotos")
@Parcelize
data class Terremoto (
    @PrimaryKey val id: String,
    @ColumnInfo(name = "place") val lugar: String,
    val magnitud: Double,
    val duracion: Long,
    val latitud: Double,
    val longitud: Double
): Parcelable