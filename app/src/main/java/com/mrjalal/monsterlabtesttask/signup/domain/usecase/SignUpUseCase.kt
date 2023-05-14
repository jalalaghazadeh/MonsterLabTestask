package com.mrjalal.monsterlabtesttask.signup.domain.usecase

import com.mrjalal.monsterlabtesttask.signup.domain.repository.UserRepository
import dagger.hilt.android.scopes.ViewModelScoped
import javax.inject.Inject
import javax.inject.Singleton

@ViewModelScoped
class SignUpUseCase @Inject constructor(
    private val userRepository: UserRepository,
) {
    fun validateEmail(email: String): Boolean {
        val emailRegex = Regex("[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}")
        return emailRegex.matches(email)
                && email.contains("@")
                && email.contains(".")
                && email.split("@").getOrNull(0)?.isNotEmpty() == true
                && email.split("@").getOrNull(1)?.isNotEmpty() == true
    }

    fun validatePassword(password: String): Boolean {
        val passwordRegex = Regex("^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$")
        return passwordRegex.matches(password)
    }

    suspend fun execute(email: String, password: String, responseCode: Int): Result<Int> {
        if (!validateEmail(email)) {
            return Result.failure(Exception("Invalid email address"))
        }
        if (!validatePassword(password)) {
            return Result.failure(Exception("Invalid password"))
        }
        return userRepository.signUp(email, password, responseCode)
    }
}