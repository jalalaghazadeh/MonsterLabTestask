package com.mrjalal.monsterlabtesttask.signup.data.dataSource.remote.signUp

import com.mrjalal.monsterlabtesttask.signup.data.dataSource.model.SignUpBody
import dagger.hilt.android.scopes.ViewModelScoped
import javax.inject.Inject


@ViewModelScoped
class UserRemoteDataSourceImpl @Inject constructor(
    private val signUpApi: MockSignUpApi
) : UserRemoteDataSource {
    override suspend fun signUp(
        email: String,
        password: String,
        responseCode: Int
    ): Result<String> {

        signUpApi.setResponseCode(responseCode)

        val body = SignUpBody(email, password)
        val response = signUpApi.signUp(body)

        return Result.success(response.token)
    }
}