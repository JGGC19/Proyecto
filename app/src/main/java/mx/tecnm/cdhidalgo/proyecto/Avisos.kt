package mx.tecnm.cdhidalgo.proyecto

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.widget.Button
import com.google.android.material.textfield.TextInputLayout

class Avisos : AppCompatActivity() {

    private lateinit var btnNuevoAviso: Button
    private lateinit var btnRegresar: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_avisos)
        replaceFragment(CasaAviso())

        btnNuevoAviso = findViewById(R.id.btnNuevoAviso)
        btnRegresar = findViewById(R.id.btnRegresar)

        btnNuevoAviso.setOnClickListener {

            val intent = Intent(this, RegistroAviso::class.java)
            startActivity(intent)

        }

        btnRegresar.setOnClickListener {
            val intent = Intent(this,Home::class.java)
            startActivity(intent)
        }


    }

    private fun replaceFragment(fragment: Fragment) {

        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frame_layout,fragment)
        fragmentTransaction.commit()

    }

}