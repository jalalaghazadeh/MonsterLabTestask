package com.mrjalal.monsterlabtesttask.signup.data.dataSource.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class SignUpBody(
    @Json(name = "email") val email: String,
    @Json(name = "password") val password: String
)