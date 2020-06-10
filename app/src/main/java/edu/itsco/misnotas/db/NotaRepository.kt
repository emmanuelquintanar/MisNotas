package edu.itsco.misnotas.db

import androidx.lifecycle.LiveData

class NotaRepository(private val notaDao: NotaDao) {

    val getAllNotas: LiveData<List<Nota>> = notaDao.getAllNotas()

    suspend fun insert(nota: Nota){
        notaDao.insert(nota)
    }


}