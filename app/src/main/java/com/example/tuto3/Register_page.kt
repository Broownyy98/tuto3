package com.example.tuto3

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputLayout

class Register_page : AppCompatActivity() {

    private val credentialsManager = CredentialsManager.getInstance()

    private val fullNameInputLayout: TextInputLayout
        get() = findViewById(R.id.name_box)

    private val fullName: String
        get() = fullNameInputLayout.editText?.text?.toString().orEmpty()

    private val emailInputLayout: TextInputLayout
        get() = findViewById(R.id.editTextTextEmailAddress)

    private val email: String
        get() = emailInputLayout.editText?.text?.toString().orEmpty()

    private val phoneNumberInputLayout: TextInputLayout
        get() = findViewById(R.id.editTextPhone)

    private val phoneNumber: String
        get() = phoneNumberInputLayout.editText?.text?.toString().orEmpty()

    private val passwordInputLayout: TextInputLayout
        get() = findViewById(R.id.editTextTextPassword)

    private val password: String
        get() = passwordInputLayout.editText?.text?.toString().orEmpty()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register_page)

        // Set up listener for login label
        val loginLabel = findViewById<TextView>(R.id.log_in)
        loginLabel.setOnClickListener {
            Log.d("RegisterActivity", "Pressed login label")
            navigateToLogin()
        }

        // Set up listener for next button
        val nextButton = findViewById<Button>(R.id.next_btn
        )
        nextButton.setOnClickListener {
            registerUser()
        }
    }

    // Function to handle user registration
    private fun registerUser() {
        var isValid = true

        // Full name validation
        if (fullName.isEmpty()) {
            fullNameInputLayout.error = "Full name is required"
            isValid = false
        } else {
            fullNameInputLayout.error = null
        }

        // Email validation
        if (!credentialsManager.isEmailValid(email)) {
            emailInputLayout.error = "Invalid email format"
            isValid = false
        } else {
            emailInputLayout.error = null
        }

        // Phone number validation
        if (phoneNumber.isEmpty() || phoneNumber.length < 10) {
            phoneNumberInputLayout.error = "Phone number must have at least 10 digits"
            isValid = false
        } else {
            phoneNumberInputLayout.error = null
        }

        // Password validation
        if (!credentialsManager.isPasswordValid(password)) {
            passwordInputLayout.error = "Password must have at least 8 chars, 1 uppercase, 1 number, and 1 symbol"
            isValid = false
        } else {
            passwordInputLayout.error = null
        }

        if (isValid) {
            val registrationSuccess = credentialsManager.register(fullName, email, phoneNumber, password)
            if (registrationSuccess) {
                Log.d("RegisterActivity", "User registered successfully")
                navigateToLogin()
            } else {
                emailInputLayout.error = "Email is already registered"
            }
        }
    }

    // Function to navigate to the login page
    private fun navigateToLogin() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }
}
