package com.mrjalal.monsterlabtesttask.signup.data.dataSource.remote.signUp

import com.mrjalal.monsterlabtesttask.core.domain.HttpCodeException

class FakeUserRemoteDataSource : UserRemoteDataSource {
    override suspend fun signUp(
        email: String,
        password: String,
        responseCode: Int
    ): Result<String> {
        return if (responseCode == 200) {
            Result.success("fake_token")
        } else {
            Result.failure(HttpCodeException(403))
        }
    }
}