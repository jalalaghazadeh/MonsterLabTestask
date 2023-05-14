package com.mrjalal.monsterlabtesttask.signup.domain.repository

import com.mrjalal.monsterlabtesttask.core.domain.HttpCodeException
import com.mrjalal.monsterlabtesttask.signup.data.dataSource.remote.signUp.UserRemoteDataSource
import junit.framework.Assert.assertEquals
import junit.framework.Assert.assertTrue
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.mock
import org.mockito.kotlin.whenever

class UserRepositoryTest {

    private lateinit var userRepository: UserRepository
    private lateinit var userRemoteDataSource: UserRemoteDataSource

    @Before
    fun setup() {
        userRemoteDataSource = mock(UserRemoteDataSource::class.java)
        userRepository = FakeUserRepository()
    }

    @Test
    fun signUp_shouldReturnHttpSuccessCode_whenSuccess() = runBlocking {
        // Arrange
        val email = "test@example.com"
        val password = "password"
        val responseCode = 200

        // Act
        val result = userRepository.signUp(email, password, responseCode)

        // Assert
        assertTrue(result.isSuccess)
        assertEquals(200, result.getOrNull())
    }

    @Test
    fun signUp_shouldReturnException_whenFails() = runBlocking {
        // Arrange
        val email = "test@example.com"
        val password = "password"
        val responseCode = 403

        // Act
        val result = userRepository.signUp(email, password, responseCode)

        // Assert
        assertTrue(result.isFailure)
        assertEquals(403, (result.exceptionOrNull() as HttpCodeException).errorCode)
    }
}
