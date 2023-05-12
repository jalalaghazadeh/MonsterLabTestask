package com.mrjalal.monsterlabtesttask.signup.data.dataSource.remote.signUp

import com.mrjalal.monsterlabtesttask.signup.domain.entity.SignUpModel

interface UserRemoteDataSource {
    suspend fun signUp(email: String, password: String, responseCode: Int): Result<String>
}