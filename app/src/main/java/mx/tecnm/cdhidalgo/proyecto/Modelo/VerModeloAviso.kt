package mx.tecnm.cdhidalgo.proyecto.Modelo

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import mx.tecnm.cdhidalgo.proyecto.Repositorios.RepositorioAviso

class VerModeloAviso : ViewModel() {

    private val repository : RepositorioAviso
    private val _allUsers = MutableLiveData<List<Aviso>>()
    val allUsers : LiveData<List<Aviso>> = _allUsers


    init {

        repository = RepositorioAviso().getInstance()
        repository.loadUsers(_allUsers)

    }

}
