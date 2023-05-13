package com.mrjalal.monsterlabtesttask.signup.data.dataSource.remote.signUp

interface UserRemoteDataSource {
    suspend fun signUp(email: String, password: String, responseCode: Int): Result<String>
}