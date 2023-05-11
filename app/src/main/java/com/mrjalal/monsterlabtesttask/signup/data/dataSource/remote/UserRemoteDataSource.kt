package com.mrjalal.monsterlabtesttask.signup.data.dataSource.remote

interface UserRemoteDataSource {
    suspend fun signUp(email: String, password: String): Result<Int>
}