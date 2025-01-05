package com.example.tuto3
import junit.framework.TestCase.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

class CredentialsManagerTest {

    // Test empty email
    @Test
    fun givenEmptyEmail_thenReturnFalse() {
        val credentialsManager = CredentialsManager()
        assertEquals(false, credentialsManager.isEmailValid(""))

    }
    // Test wrong email format

    @Test
    fun givenWrongEmailFormat_thenReturnFalse() {
        val credentialsManager = CredentialsManager()
        assertEquals(false, credentialsManager.isEmailValid("email@.rt"))
    }
    // Test proper email

    @Test
    fun givenProperEmail_thenReturnTrue() {
        val credentialsManager = CredentialsManager()
        assertEquals(true, credentialsManager.isEmailValid("email@example.com"))
    }
    // Test empty password

    @Test
    fun givenEmptyPassword_thenReturnFalse() {
        val credentialsManager = CredentialsManager()
        assertEquals(false, credentialsManager.isPasswordValid(""))
    }
    // Test filled password

    @Test
    fun givenValidPassword_thenReturnTrue() {
        val credentialsManager = CredentialsManager()
        assertEquals(true, credentialsManager.isPasswordValid("Password@1234"))
    }

    @Test
    fun givenProperUnusedCredentials() {
        val credentialsManager = CredentialsManager()
        val newEmail = "another@te.st"
        val newPassword = "1234qwer"
        credentialsManager.register("Full name", newEmail, "600 600 600", newPassword)
        val isLoginSuccess = credentialsManager.login(newEmail, newPassword)
        assertTrue(isLoginSuccess)
    }

    @Test
    fun givenTakenEmail() {
        val credentialsManager = CredentialsManager()
        val email = "test@example.com"
        credentialsManager.register("User 1", email, "600 700 800", "Password1!")
        credentialsManager.register("User 2", email, "700 800 900", "Password2!")
        val isLoginSuccess = credentialsManager.login(email, "Password1!")
        assertTrue(isLoginSuccess)
    }

    @Test
    fun givenEmailWithDifferentCaps() {
        val credentialsManager = CredentialsManager()
        val originalEmail = "Test@Example.com"
        val password = "Password@1234"
        credentialsManager.register("User", originalEmail, "600 600 600", password)
        val isLoginSuccess = credentialsManager.login("test@example.com", password)
        assertTrue(isLoginSuccess)  // Login should succeed despite case differences
    }

    @Test
    fun loginWithDifferentCaps() {
        val credentialsManager = CredentialsManager()
        val originalEmail = "Test@Example.com"
        val password = "Password@1234"
        credentialsManager.register("User", originalEmail, "600 600 600", password)
        val isLoginSuccess = credentialsManager.login("tEsT@eXaMpLe.CoM", password)
        assertTrue(isLoginSuccess)
    }

}