package com.example.tuto3

class CredentialsManager {

    fun isEmailValid(email: String): Boolean {
        if (email.isEmpty()) return false
        val emailPattern = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$"
        return Regex(emailPattern).matches(email) && !email.startsWith(".") && !email.contains("..")
    }

    fun isPasswordValid(password: String): Boolean {
        val passwordPattern = "^\\d{4,}$"
        return Regex(passwordPattern).matches(password)
    }
}