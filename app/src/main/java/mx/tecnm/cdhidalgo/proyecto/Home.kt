package mx.tecnm.cdhidalgo.proyecto

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import mx.tecnm.cdhidalgo.giftstore.DataClass.Usuario

class Home : AppCompatActivity() {

    private lateinit var btnSalir: Button
    private lateinit var btnDenuncia: Button
    private lateinit var btnNumeros: Button
    private lateinit var btnEmergencia: Button
    private lateinit var btnAvisos: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        btnSalir = findViewById(R.id.btnSalir)
        btnNumeros = findViewById(R.id.btnNumeros)
        btnAvisos = findViewById(R.id.btnAvisos)
        btnDenuncia = findViewById(R.id.btnDenuncia)
        btnEmergencia = findViewById(R.id.btnEmergencia)



        btnDenuncia.setOnClickListener {
            val intent = Intent(this,Denuncia::class.java)
            startActivity(intent)
        }

        btnNumeros.setOnClickListener {
            val intent = Intent(this,Numeros::class.java)
            startActivity(intent)
        }

        btnEmergencia.setOnClickListener {
            val intent = Intent(this,Emergencia::class.java)
            startActivity(intent)
        }

        btnAvisos.setOnClickListener {
            val intent = Intent(this,Avisos::class.java)
            startActivity(intent)
        }

        btnSalir.setOnClickListener {
            val intent = Intent(this,Login::class.java)
            startActivity(intent)
        }



    }
}