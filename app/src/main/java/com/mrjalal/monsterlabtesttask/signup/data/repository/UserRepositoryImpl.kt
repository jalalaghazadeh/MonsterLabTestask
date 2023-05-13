package com.mrjalal.monsterlabtesttask.signup.data.repository

import com.mrjalal.monsterlabtesttask.core.data.DataStoreManager
import com.mrjalal.monsterlabtesttask.core.di.qualifier.IoDispatcher
import com.mrjalal.monsterlabtesttask.signup.data.dataSource.remote.signUp.UserRemoteDataSource
import com.mrjalal.monsterlabtesttask.signup.domain.repository.UserRepository
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject

@ViewModelScoped
class UserRepositoryImpl @Inject constructor(
    private val userRemoteDataSource: UserRemoteDataSource,
    private val dataStoreManager: DataStoreManager,
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher,
) : UserRepository {
    override suspend fun signUp(email: String, password: String, responseCode: Int): Result<Int> {
        return withContext(ioDispatcher) {
            try {
                val response = userRemoteDataSource.signUp(email, password, responseCode)

                dataStoreManager.saveToken(response.getOrThrow())

                Result.success(200)
            } catch(httpException: Exception) {
                Result.failure(httpException)
            }
        }
    }
}