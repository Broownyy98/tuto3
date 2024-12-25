package com.example.tuto3

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {


    private lateinit var nameBox: EditText
    private lateinit var editTextEmailAddress: EditText
    private lateinit var editTextPhone: EditText
    private lateinit var editTextPassword: EditText


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.login_page)

        val register_button: TextView = findViewById(R.id.register_button)
        register_button.setOnClickListener {
            Log.d("LoginActivity", "Pressed register now label")
            val intent = Intent(this, Register_page::class.java)
            startActivity(intent)
            finish()
        }

    }
}