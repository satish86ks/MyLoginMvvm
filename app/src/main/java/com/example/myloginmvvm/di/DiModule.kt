package com.example.myloginmvvm.di

import com.example.myloginmvvm.remote.interfaces.Api
import com.example.myloginmvvm.remote.repository.ApiClient
import com.example.myloginmvvm.remote.repository.DataListSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class DiModule {

    @Singleton
    @Provides
    fun provideApi(): Api {
        return ApiClient.buildService()
    }

    @Provides
    fun provideDataListSource(): DataListSource {
        return DataListSource(provideApi())
    }


}