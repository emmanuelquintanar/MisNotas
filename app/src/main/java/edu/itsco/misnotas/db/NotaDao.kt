package edu.itsco.misnotas.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query


@Dao
interface NotaDao {

    @Query("Select * from tabla_notas")
    fun getAllNotas(): LiveData<List<Nota>>

    @Insert
    suspend fun insert(nota: Nota)
}