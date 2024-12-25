// Put your package name here. Check your activity for reference.
package com.example.tuto3

import junit.framework.TestCase.assertTrue
import org.junit.Assert
import org.junit.Test


class CredentialsManagerTest {
    @Test
    fun givenEmptyEmail_thenReturnFalse() {
        val credentialsManager = CredentialsManager()
        val isEmailValid = credentialsManager.isEmailValid("")
        Assert.assertEquals(false, isEmailValid)
    }

    @Test
    fun givenProperEmail_thenReturnTrue() {
        val credentialsManager = CredentialsManager()
        val isEmailValid = credentialsManager.isEmailValid("email@example.com")
        Assert.assertEquals(true, isEmailValid)
    }

    @Test
    fun givenWrongEmailFormat_thenReturnFalse() {
        val credentialsManager = CredentialsManager()
        val isEmailValid = credentialsManager.isEmailValid("email@.st")
        Assert.assertEquals(false, isEmailValid)
    }

    @Test
    fun givenEmptyPassword_thenReturnFalse() {
        val credentialsManager = CredentialsManager()
        Assert.assertEquals(false, credentialsManager.isPasswordValid(""))
    }

    @Test
    fun givenValidPassword_thenReturnTrue() {
        val credentialsManager = CredentialsManager()
        Assert.assertEquals(true, credentialsManager.isPasswordValid("StrongP@ssw0rd"))
    }
}