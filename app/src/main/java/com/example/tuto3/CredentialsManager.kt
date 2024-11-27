package com.example.tuto3

class CredentialsManager {
    fun isEmailValid(email: String): Boolean {
        val emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$"
        return email.isNotEmpty() && email.matches(emailRegex.toRegex())
    }
}
