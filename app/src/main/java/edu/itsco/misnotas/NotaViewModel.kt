package edu.itsco.misnotas

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import edu.itsco.misnotas.db.Nota
import edu.itsco.misnotas.db.NotaRepository
import edu.itsco.misnotas.db.NotasDatabaseRoom
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NotaViewModel(application: Application): AndroidViewModel(application) {

    private val repository: NotaRepository

    val allNotas: LiveData<List<Nota>>

    init {
        val notaDao = NotasDatabaseRoom.getDatabase(application).notaDao()
        repository = NotaRepository(notaDao)
        allNotas = repository.getAllNotas
    }

    fun insert(nota:Nota)=viewModelScope.launch(Dispatchers.IO) {
        repository.insert(nota)
    }
}