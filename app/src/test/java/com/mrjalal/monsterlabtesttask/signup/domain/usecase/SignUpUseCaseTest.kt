package com.mrjalal.monsterlabtesttask.signup.domain.usecase

import com.mrjalal.monsterlabtesttask.signup.domain.repository.FakeUserRepository
import com.mrjalal.monsterlabtesttask.signup.domain.repository.UserRepository
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class SignUpUseCaseTest {

    private lateinit var signUpUseCase: SignUpUseCase

    private lateinit var userRepository: UserRepository

    @Before
    fun setUp() {
        userRepository = FakeUserRepository()
        signUpUseCase = SignUpUseCase(userRepository)
    }

    @Test
    fun execute_shouldReturnsFailure_whenEmailIsInvalid() = runBlocking {
        val email = "invalid@email"
        val password = "validPa33word"
        val responseCode = 200

        val result: Result<Int> = signUpUseCase.execute(email, password, responseCode)

        assertEquals("Invalid email address", result.exceptionOrNull()?.message)
    }

    @Test
    fun execute_shouldReturnsFailure_whenPasswordIsInvalid() = runBlocking {
        val email = "valid@email.com"
        val password = "invalidPassword"
        val responseCode = 200

        val result = signUpUseCase.execute(email, password, responseCode)

        assertEquals("Invalid password", result.exceptionOrNull()?.message)
    }

    @Test
    fun execute_shouldReturnsSuccess_whenEmailAndPasswordIsValid() = runBlocking {
        // region ARRANGE
        val email = "validemail@example.com"
        val password = "validPa33word"
        val responseCode = 200
        // endregion

        // region ACT
        val result = signUpUseCase.execute(email, password, responseCode)
        // endregion

        // region ASSERT
        assertEquals(Result.success(200), result)
        // endregion
    }
}

