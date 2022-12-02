package mx.tecnm.cdhidalgo.proyecto

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.google.android.material.textfield.TextInputLayout

class Registro : AppCompatActivity() {

    private lateinit var nombre: TextInputLayout
    private lateinit var apaterno: TextInputLayout
    private lateinit var amaterno: TextInputLayout
    private lateinit var correo: TextInputLayout
    private lateinit var pass: TextInputLayout

    private lateinit var btnConfirmar: Button
    private lateinit var btnEstoyRegistrado: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro)

        nombre = findViewById(R.id.txtNombre)
        apaterno = findViewById(R.id.txtApaterno)
        amaterno = findViewById(R.id.txtAmaterno)
        correo = findViewById(R.id.txtCorreo)
        pass = findViewById(R.id.txtPass)

        btnConfirmar = findViewById(R.id.btnRegistrarme)
        btnEstoyRegistrado = findViewById(R.id.btnEstoyRegistrado)

        btnConfirmar.setOnClickListener {
            val intent = Intent(this, ConfirmarRegistro::class.java)
            intent.putExtra("nombre", nombre.editText?.text.toString())
            intent.putExtra("apaterno", apaterno.editText?.text.toString())
            intent.putExtra("amaterno", amaterno.editText?.text.toString())
            intent.putExtra("correo", correo.editText?.text.toString())
            intent.putExtra("password", pass.editText?.text.toString())
            startActivity(intent)
        }

        btnEstoyRegistrado.setOnClickListener {
            val intent = Intent(this, Login::class.java)
            startActivity(intent)
        }
    }
}