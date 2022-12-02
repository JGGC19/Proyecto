package mx.tecnm.cdhidalgo.proyecto.Modelo

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import mx.tecnm.cdhidalgo.proyecto.Repositorios.RepositorioNumero

class VerModeloNumero : ViewModel() {

    private val repository : RepositorioNumero
    private val _allUsers = MutableLiveData<List<Numero>>()
    val allUsers : LiveData<List<Numero>> = _allUsers


    init {

        repository = RepositorioNumero().getInstance()
        repository.loadUsers(_allUsers)

    }

}