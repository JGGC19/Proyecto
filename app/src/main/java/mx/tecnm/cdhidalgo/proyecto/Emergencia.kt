package mx.tecnm.cdhidalgo.proyecto

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.telephony.SmsManager
import android.widget.Button

class Emergencia : AppCompatActivity() {

    private lateinit var btnAlerta: Button
    private lateinit var btnRegresar: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_emergencia)

        btnAlerta = findViewById(R.id.btnAlerta)
        btnRegresar = findViewById(R.id.btnRegresar)

        btnAlerta.setOnClickListener {

            var obj = SmsManager.getDefault()

            obj.sendTextMessage("7861704152",
                null,
                "Estoy utilizando la aplicacion de ALERT!, utilizando el boton de emergencia solicito una caguama",
                null,null)

        }

        btnRegresar.setOnClickListener {
            val intent = Intent(this,Home::class.java)
            startActivity(intent)
        }


    }
}