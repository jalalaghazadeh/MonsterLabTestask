package com.mrjalal.monsterlabtesttask.signup.data.dataSource.remote

import dagger.hilt.android.scopes.ViewModelScoped
import javax.inject.Inject

@ViewModelScoped
class UserRemoteDataSourceImpl @Inject constructor(): UserRemoteDataSource {
    override suspend fun signUp(email: String, password: String): Result<Int> {
        // TODO: call Mock Api function
        return Result.success(0)
    }
}