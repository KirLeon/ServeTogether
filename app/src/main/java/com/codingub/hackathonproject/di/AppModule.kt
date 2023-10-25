package com.codingub.hackathonproject.di

import com.codingub.hackathonproject.MainApp
import com.codingub.hackathonproject.data.remote.AppApi
import com.codingub.hackathonproject.network.AppNetworking
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {


    /**
     *  Networking
     */
    @Provides
    @Singleton
    fun provideHistoryAppService(networking: AppNetworking) : AppApi =
        networking.provideAPI()

    /**
     *  provides [ApplicationConfig]
     */
    @Provides
    @Singleton
    fun provideApp(): MainApp {
        return MainApp.getInstance()
    }

}