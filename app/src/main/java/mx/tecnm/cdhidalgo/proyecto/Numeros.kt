package mx.tecnm.cdhidalgo.proyecto

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.fragment.app.Fragment

class Numeros : AppCompatActivity() {

    private lateinit var btnNuevoAviso: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_numeros)
        replaceFragment(CasaNumero())

        btnNuevoAviso = findViewById(R.id.btnNuevoAviso)

        btnNuevoAviso.setOnClickListener {

            val intent = Intent(this, Home::class.java)
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