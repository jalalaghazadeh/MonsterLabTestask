package com.mrjalal.monsterlabtesttask.signup.data.dataSource.remote.signUp

import com.mrjalal.monsterlabtesttask.core.domain.HttpCodeException
import com.mrjalal.monsterlabtesttask.signup.data.dataSource.model.SignUpBody
import com.mrjalal.monsterlabtesttask.signup.data.dataSource.model.SignUpResponse
import kotlinx.coroutines.delay

class MockSignUpApi : SignUpApi {
    private var mockResponseCode: Int = 200

    override suspend fun signUp(body: SignUpBody): SignUpResponse {

        val response = getMockResponse(mockResponseCode)
        delay(1000)
        return response
    }

    fun setResponseCode(code: Int) {
        this.mockResponseCode = code
    }

    private fun getMockResponse(responseCode: Int): SignUpResponse {
        if(responseCode != 200) {
            throw HttpCodeException(mockResponseCode)
        }

        return SignUpResponse(token = "SomeLongString")
    }
}