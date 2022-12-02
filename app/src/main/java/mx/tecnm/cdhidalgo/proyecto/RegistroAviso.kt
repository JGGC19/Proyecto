package mx.tecnm.cdhidalgo.proyecto

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.android.material.textfield.TextInputLayout
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import mx.tecnm.cdhidalgo.proyecto.Modelo.Aviso
import mx.tecnm.cdhidalgo.proyecto.Modelo.AvisoDos

class RegistroAviso : AppCompatActivity() {

    private lateinit var etEmpTitle: TextInputLayout
    private lateinit var etEmpDes: TextInputLayout

    private lateinit var btnSaveData: Button
    private lateinit var btnEstoyRegistrado: Button



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro_aviso)

        etEmpTitle = findViewById(R.id.txtTitulo)
        etEmpDes = findViewById(R.id.txtDescripcionUno)

        btnSaveData = findViewById(R.id.btnRegistrarAviso)
        btnEstoyRegistrado = findViewById(R.id.btnEstoyRegistrado)


        btnSaveData.setOnClickListener {
            val intent = Intent(this, ConfirmarAviso::class.java)
            intent.putExtra("titulo", etEmpTitle.editText?.text.toString())
            intent.putExtra("descripcion", etEmpDes.editText?.text.toString())
            startActivity(intent)
        }

        btnEstoyRegistrado.setOnClickListener {
            val intent = Intent(this, Avisos::class.java)
            startActivity(intent)
        }

    }


}