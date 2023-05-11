package com.mrjalal.monsterlabtesttask.signup.domain.repository

interface UserRepository {
    suspend fun signUp(email: String, password: String): Result<Int>
}