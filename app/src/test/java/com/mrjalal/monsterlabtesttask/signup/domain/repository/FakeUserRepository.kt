package com.mrjalal.monsterlabtesttask.signup.domain.repository

import com.mrjalal.monsterlabtesttask.core.domain.HttpCodeException

class FakeUserRepository : UserRepository {
    override suspend fun signUp(email: String, password: String, responseCode: Int): Result<Int> {
        return if (responseCode == 200) {
            Result.success(200)
        } else {
            Result.failure(HttpCodeException(403))
        }
    }
}
