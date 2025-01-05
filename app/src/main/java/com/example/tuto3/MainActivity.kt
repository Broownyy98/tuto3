package com.example.tuto3

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputLayout

class MainActivity : AppCompatActivity() {

    private val credentialsManager = CredentialsManager()

    private val emailInputLayout: TextInputLayout
        get() = findViewById(R.id.name_box)

    private val email: String
        get() = emailInputLayout.editText?.text?.toString().orEmpty()

    private val passwordInputLayout: TextInputLayout
        get() = findViewById(R.id.valid_email)

    private val password: String
        get() = passwordInputLayout.editText?.text?.toString().orEmpty()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login_page)

        // Listener for the "Register Now" text view
        val registerNowTextView = findViewById<TextView>(R.id.register_button)
        registerNowTextView.setOnClickListener {
            Log.d("MainActivity", "Pressed register now label")
            val intent = Intent(this, Register_page::class.java)
            startActivity(intent)
            finish() // Finish this activity to prevent returning to it
        }

        // Listener for the "Next" button
        val nextButton = findViewById<Button>(R.id.next_button)
        nextButton.setOnClickListener {
            Log.d("MainActivity", "Next button clicked")
            if (credentialsManager.isEmailValid(email) && credentialsManager.isPasswordValid(password)) {
                Log.d("MainActivity", "Valid credentials")
                val nextIntent = Intent(this, NewActivity::class.java)
                startActivity(nextIntent)
                finish() // Finish this activity after successful login
            } else {
                // Handle invalid email
                if (!credentialsManager.isEmailValid(email)) {
                    emailInputLayout.error = "Invalid email format"
                } else {
                    emailInputLayout.error = null
                }

                // Handle invalid password
                if (!credentialsManager.isPasswordValid(password)) {
                    passwordInputLayout.error =
                        "Password must have at least 8 chars, 1 uppercase, 1 number, and 1 symbol"
                } else {
                    passwordInputLayout.error = null
                }
            }
        }
    }
}
