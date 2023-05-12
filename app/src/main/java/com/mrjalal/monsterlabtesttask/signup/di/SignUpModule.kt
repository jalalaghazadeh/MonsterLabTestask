package com.mrjalal.monsterlabtesttask.signup.di

import com.mrjalal.monsterlabtesttask.signup.data.dataSource.remote.signUp.MockSignUpApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
object SignUpModule {

    @Provides
    fun provideMockSignUpApi(): MockSignUpApi = MockSignUpApi()
}