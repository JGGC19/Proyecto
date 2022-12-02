package mx.tecnm.cdhidalgo.proyecto

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import mx.tecnm.cdhidalgo.giftstore.DataClass.Usuario
import mx.tecnm.cdhidalgo.proyecto.Modelo.AvisoDos

class ConfirmarAviso : AppCompatActivity() {

    private lateinit var texto1: TextView
    private lateinit var texto2: TextView
    private lateinit var btnConfirmar: Button
    private lateinit var btnCorregir: Button

    private lateinit var dbRef: DatabaseReference


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_confirmar_aviso)

        dbRef = FirebaseDatabase.getInstance().getReference("aviso")

        texto1 = findViewById(R.id.etiqueta1)
        texto2 = findViewById(R.id.etiqueta2)

        btnConfirmar = findViewById(R.id.btnConfirmar)
        btnCorregir = findViewById(R.id.btnCorregir)

        val titulo = intent.getStringExtra("titulo")
        val descripcion = intent.getStringExtra("descripcion")

        val empId = dbRef.push().key!!


        texto1.text = "Segur@ de publicar el sigiente aviso..."

        texto2.text = "Titulo: $titulo\n" +
                "Descripcion: $descripcion\n"


        btnConfirmar.setOnClickListener {
            val intent = Intent(this, Avisos::class.java)
            val aviso = AvisoDos(
                empId, titulo.toString(), descripcion.toString()
            )
            dbRef.child(empId).setValue(aviso)
                .addOnCompleteListener {
                    Toast.makeText(this, "Data inserted successfully", Toast.LENGTH_LONG).show()


                }.addOnFailureListener { err ->
                    Toast.makeText(this, "Error ${err.message}", Toast.LENGTH_LONG).show()
                }
            startActivity(intent)
        }

        btnCorregir.setOnClickListener {
            finish()
        }

    }
}