package com.mrjalal.monsterlabtesttask.signup.data.dataSource.remote.signUp

import com.mrjalal.monsterlabtesttask.core.domain.HttpCodeException
import junit.framework.Assert.assertEquals
import junit.framework.Assert.assertTrue
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

class UserRemoteDataSourceTest {
    private lateinit var userRemoteDataSource: UserRemoteDataSource

    @Before
    fun setup() {
        userRemoteDataSource = FakeUserRemoteDataSource()
    }

    @Test
    fun signUp_shouldReturnToken_whenSuccess() = runBlocking {
        val result = userRemoteDataSource.signUp("mrjalal@email.com", "password", 200)
        assertTrue(result.isSuccess)
        assertEquals("fake_token", result.getOrNull())
    }

    @Test
    fun signUp_shouldReturnException_whenFails() = runBlocking {
        val result = userRemoteDataSource.signUp("mrjalal@email.com", "password", 403)
        assertTrue(result.isFailure)
        assertEquals(403, (result.exceptionOrNull() as HttpCodeException).errorCode)
    }
}