package com.mrjalal.monsterlabtesttask.core.di.module

import com.mrjalal.monsterlabtesttask.core.data.ApiCallFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object CoreModule {

//    @Provides
//    fun provideApiCallFactory(): ApiCallFactory = ApiCallFactory()
}