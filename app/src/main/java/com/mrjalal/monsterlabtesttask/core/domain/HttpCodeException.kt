package com.mrjalal.monsterlabtesttask.core.domain

class HttpCodeException(val errorCode: Int) : Exception() {
    override val message: String
        get() = "HTTP $errorCode Error"
}
