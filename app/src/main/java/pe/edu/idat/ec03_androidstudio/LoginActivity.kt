package pe.edu.idat.ec03_androidstudio

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class LoginActivity : AppCompatActivity() {

    private lateinit var txtEmail: EditText
    private lateinit var txtContraseña: EditText
    private lateinit var btnAcceder: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        setContentView(R.layout.activity_login)

        txtEmail = findViewById(R.id.txtEmail)
        txtContraseña = findViewById(R.id.txtContraseña)
        btnAcceder = findViewById(R.id.btnAcceder)

        btnAcceder.setOnClickListener { login() }

    }

    private fun login() {
        val username = txtEmail.text.toString().trim()
        val password = txtContraseña.text.toString().trim()

        // Verifica si los campos de usuario y contraseña no están vacíos
        if (username.isNotEmpty() && password.isNotEmpty()) {

            if (username == "Aperez" && password == "SYS123") {
                // Autenticación exitosa, inicia MainActivity
                startActivity(Intent(this, MainActivity::class.java))
                finish() // Finaliza LoginActivity para que no pueda volver atrás
            } else {
                // Autenticación fallida
                mostrarMensaje("Usuario o contraseña incorrectos")
            }
        } else {
            // Campos de usuario o contraseña vacíos
            mostrarMensaje("Por favor, introduce tu usuario y contraseña")
        }
    }

    // Función para mostrar mensajes usando Toast
    private fun mostrarMensaje(mensaje: String) {
        Toast.makeText(this, mensaje, Toast.LENGTH_SHORT).show()
    }

}