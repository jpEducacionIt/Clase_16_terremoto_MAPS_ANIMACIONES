package com.example.clase7viewmodelrepository

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface TerremotoDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(terromotoList: MutableList<Terremoto>)

    @Query("SELECT * FROM terremotos")
    fun getAll(): LiveData<MutableList<Terremoto>>

    @Query("SELECT * FROM terremotos WHERE magnitud > :mag")
    fun getAllWithMagnitud(mag: Double): MutableList<Terremoto>

    @Update
    fun update(terremoto: Terremoto)

    @Delete
    fun delete(terremoto: Terremoto)

    @Delete
    fun deleteVarios(vararg terremoto: Terremoto)
}