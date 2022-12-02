package mx.tecnm.cdhidalgo.proyecto

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputLayout
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import mx.tecnm.cdhidalgo.giftstore.DataClass.Usuario

class Login : AppCompatActivity() {

    private lateinit var correo: TextInputLayout
    private lateinit var password: TextInputLayout

    private lateinit var btnIngresar: MaterialButton
    private lateinit var btnNoEstoyRegistrado: MaterialButton


    private lateinit var usuario: Usuario

    private lateinit var auth: FirebaseAuth


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        auth = Firebase.auth
        val db = Firebase.firestore

        correo = findViewById(R.id.txtCorreo)
        password = findViewById(R.id.txtPass)

        btnIngresar = findViewById(R.id.btnIngresar)
        btnNoEstoyRegistrado = findViewById(R.id.btnRegistrar)

        btnNoEstoyRegistrado.setOnClickListener {
            val intent = Intent(this, Registro::class.java)
            startActivity(intent)
        }

        btnIngresar.setOnClickListener {
            if (correo.editText?.text.toString().isNotEmpty() &&
                password.editText?.text.toString().isNotEmpty()
            )
                auth.signInWithEmailAndPassword(
                    correo.editText?.text.toString(),
                    password.editText?.text.toString()
                ).addOnCompleteListener {
                    if (it.isSuccessful) {
                        db.collection("usuarios")
                            .whereEqualTo("correo", correo.editText?.text.toString())
                            .get().addOnSuccessListener { documents ->
                                for (document in documents){
                                    usuario = Usuario(
                                        "${document.data.get("correo")}",
                                        "${document.data.get("nombre")}",
                                        "${document.data.get("apaterno")}",
                                        "${document.data.get("amaterno")}"
                                    )
                                }
                                val intent = Intent(this, Home::class.java)
                                intent.putExtra("usuario",usuario)
                                startActivity(intent)
                            }

                    } else {
                        showAlert()
                    }
                }
        }

    }

    private fun showAlert() {
        val builder = androidx.appcompat.app.AlertDialog.Builder(this)
        builder.setTitle("Error")
        builder.setMessage("Se ha producido un error en la autenficacion del usuario!!")
        builder.setPositiveButton("Aceptar", null)
        val dialog: androidx.appcompat.app.AlertDialog = builder.create()
        dialog.show()
    }

}