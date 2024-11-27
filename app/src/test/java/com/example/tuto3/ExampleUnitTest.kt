package com.example.tuto3

import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun givenEmptyEmail_thenReturnFalse() {
        val credentialsManager = ExampleUnitTest()
        val isEmailValid = credentialsManager.isEmailValid("")
        assertEquals(false, isEmailValid)

    }
}