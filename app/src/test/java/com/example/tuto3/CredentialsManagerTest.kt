// Put your package name here. Check your activity for reference.
package com.example.tuto3

import junit.framework.TestCase.assertEquals
import org.junit.Test


class CredentialsManagerTest {

    // Test empty email
    @Test
    fun givenWrongEmailFormat_thenReturnFalse() {
        val credentialsManager = CredentialsManager()

        val isEmailValid = credentialsManager.isEmailValid("invalid-email")

        assertEquals(false, isEmailValid)
    }

    @Test
    fun givenProperEmail_thenReturnTrue() {
        val credentialsManager = CredentialsManager()

        val isEmailValid = credentialsManager.isEmailValid("user@example.com")

        assertEquals(true, isEmailValid)
    }

    @Test
    fun givenEmptyPassword_thenReturnFalse() {
        val credentialsManager = CredentialsManager()

        val isPasswordValid = credentialsManager.isPasswordValid("")

        assertEquals(false, isPasswordValid)
    }

    @Test
    fun givenFilledPassword_thenReturnTrue() {
        val credentialsManager = CredentialsManager()

        val isPasswordValid = credentialsManager.isPasswordValid("password123")

        assertEquals(true, isPasswordValid)
    }



    // Test wrong email format
    // Test proper email

    // Test empty password
    // Test filled password
}