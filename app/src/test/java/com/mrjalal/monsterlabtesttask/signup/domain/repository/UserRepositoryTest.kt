package com.mrjalal.monsterlabtesttask.signup.domain.repository

import com.mrjalal.monsterlabtesttask.core.domain.HttpCodeException
import com.mrjalal.monsterlabtesttask.signup.data.dataSource.remote.signUp.FakeUserRemoteDataSource
import com.mrjalal.monsterlabtesttask.signup.data.dataSource.remote.signUp.UserRemoteDataSource
import org.junit.Assert.assertEquals
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test

class UserRepositoryTest {

    private lateinit var userRepository: UserRepository
    private lateinit var userRemoteDataSource: UserRemoteDataSource

    @Before
    fun setup() {
        userRemoteDataSource = FakeUserRemoteDataSource()
        userRepository = FakeUserRepository()
    }

    @Test
    fun signUp_shouldReturnHttpSuccessCode_whenSuccess() = runBlocking {
        // region Arrange
        val email = "test@example.com"
        val password = "password"
        val responseCode = 200
        // endregion

        // region Act
        val result = userRepository.signUp(email, password, responseCode)
        // endregion

        // region Assert
        assertTrue(result.isSuccess)
        assertEquals(200, result.getOrNull())
        // endregion
    }

    @Test
    fun signUp_shouldReturnException_whenFails() = runBlocking {
        // region Arrange
        val email = "test@example.com"
        val password = "password"
        val responseCode = 403
        // endregion

        // region Act
        val result = userRepository.signUp(email, password, responseCode)
        // endregion

        // region Assert
        assertTrue(result.isFailure)
        assertEquals(403, (result.exceptionOrNull() as HttpCodeException).errorCode)
        // endregion
    }
}
