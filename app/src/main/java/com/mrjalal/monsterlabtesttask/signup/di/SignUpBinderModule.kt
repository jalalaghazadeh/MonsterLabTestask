package com.mrjalal.monsterlabtesttask.signup.di

import com.mrjalal.monsterlabtesttask.signup.data.dataSource.remote.UserRemoteDataSource
import com.mrjalal.monsterlabtesttask.signup.data.dataSource.remote.UserRemoteDataSourceImpl
import com.mrjalal.monsterlabtesttask.signup.data.repository.UserRepositoryImpl
import com.mrjalal.monsterlabtesttask.signup.domain.repository.UserRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(ViewModelComponent::class)
abstract class SignUpBinderModule {

    @Binds
    abstract fun bindUserRemoteDataSource(userRemoteDataSourceImpl: UserRemoteDataSourceImpl): UserRemoteDataSource

    @Binds
    abstract fun bindUserRepository(userRepositoryImpl: UserRepositoryImpl): UserRepository
}