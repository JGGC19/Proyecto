package mx.tecnm.cdhidalgo.proyecto

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.google.android.material.textfield.TextInputLayout

class Denuncia : AppCompatActivity() {

    private lateinit var txtDelito: TextInputLayout
    private lateinit var txtUbicacion: TextInputLayout
    private lateinit var txtDescripcion: TextInputLayout

    private lateinit var btnReportar: Button
    private lateinit var btnRegresar: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_denuncia)

        txtDelito = findViewById(R.id.txtDelito)
        txtUbicacion = findViewById(R.id.txtUbicacion)
        txtDescripcion = findViewById(R.id.txtDescripcion)

        btnReportar = findViewById(R.id.btnReportar)
        btnRegresar = findViewById(R.id.btnRegresar)

        btnReportar.setOnClickListener {
            val intent = Intent(this, ConfirmarDenuncia::class.java)
            intent.putExtra("delito", txtDelito.editText?.text.toString())
            intent.putExtra("ubicacion", txtUbicacion.editText?.text.toString())
            intent.putExtra("descripcion", txtDescripcion.editText?.text.toString())
            startActivity(intent)
        }

        btnRegresar.setOnClickListener {
            val intent = Intent(this,Home::class.java)
            startActivity(intent)
        }
    }


}