package com.codingub.hackathonproject.di

import com.codingub.hackathonproject.BuildConfig
import com.codingub.hackathonproject.utils.Constants.Injection.BUILD_VERSION_CODE
import com.codingub.hackathonproject.utils.Constants.Injection.BUILD_VERSION_NAME
import com.codingub.hackathonproject.utils.Constants.Injection.IS_DEBUG
import com.codingub.hackathonproject.utils.Constants.Injection.RETROFIT_ENDPOINT
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Named

@Module
@InstallIn(SingletonComponent::class)
class AppModuleBinds {

    @Provides
    @Named(IS_DEBUG)
    fun providesIsDebug() : Boolean = BuildConfig.DEBUG

    @Provides
    @Named(BUILD_VERSION_CODE)
    fun providesBuildVersionCode() = BuildConfig.VERSION_CODE

    @Provides
    @Named(BUILD_VERSION_NAME)
    fun providesBuildVersionName() = BuildConfig.VERSION_NAME

    @Provides
    @Named(RETROFIT_ENDPOINT)
    fun providesAppEndpoint() = BuildConfig.Endpoint
}