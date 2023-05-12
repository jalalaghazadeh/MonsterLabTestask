package com.mrjalal.monsterlabtesttask.signup.data.dataSource.remote.signUp

import com.mrjalal.monsterlabtesttask.signup.data.dataSource.model.SignUpBody
import com.mrjalal.monsterlabtesttask.signup.data.dataSource.model.SignUpResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface SignUpApi {
    @POST("signup")
    suspend fun signUp(@Body body: SignUpBody): SignUpResponse
}