package com.mrjalal.monsterlabtesttask.signup.domain.usecase

import com.mrjalal.monsterlabtesttask.signup.domain.repository.UserRepository
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.mock
import org.mockito.Mockito.`when`

@ExperimentalCoroutinesApi
class SignUpUseCaseTest {

    private lateinit var signUpUseCase: SignUpUseCase

    @Mock
    private lateinit var userRepository: UserRepository

    @Before
    fun setUp() {
        userRepository = mock(UserRepository::class.java)
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
        val email = "validemail@example.com"
        val password = "validPa33word"
        val responseCode = 200

        `when`(userRepository.signUp(email, password, responseCode)).thenReturn(Result.success(200))

        val result = signUpUseCase.execute(email, password, responseCode)

        assertEquals(Result.success(200), result.getOrNull())
    }
}

