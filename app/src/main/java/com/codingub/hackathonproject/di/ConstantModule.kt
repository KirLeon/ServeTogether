package com.codingub.hackathonproject.di

import com.codingub.hackathonproject.BuildConfig
import com.codingub.hackathonproject.utils.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Named

@Module
@InstallIn(SingletonComponent::class)
class ConstantModule {

    @Provides
    @Named(Constants.Injection.IS_DEBUG)
    fun providesIsDebug() : Boolean = BuildConfig.DEBUG

    @Provides
    @Named(Constants.Injection.BUILD_VERSION_CODE)
    fun providesBuildVersionCode() = BuildConfig.VERSION_CODE

    @Provides
    @Named(Constants.Injection.BUILD_VERSION_NAME)
    fun providesBuildVersionName() = BuildConfig.VERSION_NAME

    @Provides
    @Named(Constants.Injection.RETROFIT_ENDPOINT)
    fun providesAppEndpoint() = BuildConfig.Endpoint
}