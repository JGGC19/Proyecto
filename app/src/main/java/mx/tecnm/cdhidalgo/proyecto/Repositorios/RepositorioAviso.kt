package mx.tecnm.cdhidalgo.proyecto.Repositorios

import androidx.lifecycle.MutableLiveData
import com.google.firebase.database.*
import mx.tecnm.cdhidalgo.proyecto.Modelo.Aviso

class RepositorioAviso {

    private val databaseReference : DatabaseReference = FirebaseDatabase.getInstance().getReference("aviso")

    @Volatile private var INSTANCE : RepositorioAviso ?= null

    fun getInstance() : RepositorioAviso{
        return INSTANCE ?: synchronized(this){

            val instance = RepositorioAviso()
            INSTANCE = instance
            instance
        }


    }


    fun loadUsers(userList : MutableLiveData<List<Aviso>>){

        databaseReference.addValueEventListener(object : ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {

                try {

                    val _userList : List<Aviso> = snapshot.children.map { dataSnapshot ->

                        dataSnapshot.getValue(Aviso::class.java)!!

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
