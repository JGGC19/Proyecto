package mx.tecnm.cdhidalgo.proyecto

import android.app.AlertDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import mx.tecnm.cdhidalgo.giftstore.DataClass.Usuario
import mx.tecnm.cdhidalgo.proyecto.DataClass.Denuncia

class ConfirmarDenuncia : AppCompatActivity() {

    private lateinit var texto1: TextView
    private lateinit var texto2: TextView
    private lateinit var btnConfirmar: Button
    private lateinit var btnCorregir: Button

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_confirmar_denuncia)


        val db = Firebase.firestore

        texto1 = findViewById(R.id.etiqueta1)
        texto2 = findViewById(R.id.etiqueta2)

        btnConfirmar = findViewById(R.id.btnConfirmar)
        btnCorregir = findViewById(R.id.btnCorregir)

        val delito  = intent.getStringExtra("delito")
        val ubicacion = intent.getStringExtra("ubicacion")
        val descripcion = intent.getStringExtra("descripcion")

        texto1.text = "Los datos de la denuncia son:"
        texto2.text = "Delito a denunciar: $delito\n" +
                "Ubicacion del delito: $ubicacion\n" +
                "Descripcion de los echos: $descripcion"


        btnConfirmar.setOnClickListener {
            val intent = Intent(this, Home::class.java)
            val denuncia = Denuncia(
                delito.toString(), ubicacion.toString(), descripcion.toString()
            )

            db.collection("denuncias")
                .document()
                .set(denuncia)

            startActivity(intent)
        }

        btnCorregir.setOnClickListener {
            finish()
        }
    }
}