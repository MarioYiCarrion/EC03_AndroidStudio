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
        val username = txtEmail.text.toString()
        val password = txtContraseña.text.toString()
        if (username == "Aperez" && password == "SYS123") {
            // Autenticación exitosa, iniciar MainActivity
            startActivity(Intent(this, MainActivity::class.java))
            finish() // Finaliza LoginActivity para que no pueda volver atrás
        } else {
            // Autenticación fallida
            Toast.makeText(this, "Usuario o contraseña incorrectos", Toast.LENGTH_SHORT).show()
        }
    }
}