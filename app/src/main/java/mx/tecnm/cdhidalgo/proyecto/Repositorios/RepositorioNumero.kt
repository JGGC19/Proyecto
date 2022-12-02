package mx.tecnm.cdhidalgo.proyecto.Repositorios

import androidx.lifecycle.MutableLiveData
import com.google.firebase.database.*
import mx.tecnm.cdhidalgo.proyecto.Modelo.Numero

class RepositorioNumero {

    private val databaseReference : DatabaseReference = FirebaseDatabase.getInstance().getReference("instituciones")

    @Volatile private var INSTANCE : RepositorioNumero ?= null

    fun getInstance() : RepositorioNumero{
        return INSTANCE ?: synchronized(this){

            val instance = RepositorioNumero()
            INSTANCE = instance
            instance
        }


    }


    fun loadUsers(userList : MutableLiveData<List<Numero>>){

        databaseReference.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {

                try {

                    val _userList : List<Numero> = snapshot.children.map { dataSnapshot ->

                        dataSnapshot.getValue(Numero::class.java)!!

                    }

                    userList.postValue(_userList)

                }catch (e : Exception){


                }


            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }


        })


    }

}