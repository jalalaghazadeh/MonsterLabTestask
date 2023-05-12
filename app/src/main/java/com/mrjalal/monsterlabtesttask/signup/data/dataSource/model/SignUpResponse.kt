package com.mrjalal.monsterlabtesttask.signup.data.dataSource.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class SignUpResponse(
    @Json(name = "token") val token: String
)
