package com.mrjalal.monsterlabtesttask.signup.data.repository

import com.mrjalal.monsterlabtesttask.core.di.qualifier.IoDispatcher
import com.mrjalal.monsterlabtesttask.signup.data.dataSource.remote.UserRemoteDataSource
import com.mrjalal.monsterlabtesttask.signup.domain.repository.UserRepository
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject

@ViewModelScoped
class UserRepositoryImpl @Inject constructor(
    private val userRemoteDataSource: UserRemoteDataSource,
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher,
) : UserRepository {
    override suspend fun signUp(email: String, password: String): Result<Int> {
        return withContext(ioDispatcher) {
            userRemoteDataSource.signUp(email, password)
        }
    }
}