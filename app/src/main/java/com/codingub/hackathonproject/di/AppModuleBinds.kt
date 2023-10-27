package com.codingub.hackathonproject.di

import com.codingub.hackathonproject.BuildConfig
import com.codingub.hackathonproject.utils.Constants.Injection.BUILD_VERSION_CODE
import com.codingub.hackathonproject.utils.Constants.Injection.BUILD_VERSION_NAME
import com.codingub.hackathonproject.utils.Constants.Injection.IS_DEBUG
import com.codingub.hackathonproject.utils.Constants.Injection.RETROFIT_ENDPOINT
import com.codingub.hackathonproject.utils.logger.AppLogger
import com.codingub.hackathonproject.utils.logger.Logger
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class AppModuleBinds {

    @Singleton
    @Binds
    abstract fun bindsLogger(bind: AppLogger) : Logger
}