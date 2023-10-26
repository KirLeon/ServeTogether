package com.codingub.hackathonproject.di

import com.codingub.hackathonproject.data.repositories.AnnouncementRepository
import com.codingub.hackathonproject.data.repositories.AnnouncementRepositoryImpl
import com.codingub.hackathonproject.data.repositories.AuthRepository
import com.codingub.hackathonproject.data.repositories.AuthRepositoryImpl
import com.codingub.hackathonproject.data.repositories.MarketRepository
import com.codingub.hackathonproject.data.repositories.MarketRepositoryImpl
import com.codingub.hackathonproject.data.repositories.UserRepository
import com.codingub.hackathonproject.data.repositories.UserRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
class ViewModuleModule {

    @Provides
    @ViewModelScoped
    fun providesAuthRepository(repository: AuthRepositoryImpl): AuthRepository = repository

    @Provides
    @ViewModelScoped
    fun providesMarketRepository(repository: MarketRepositoryImpl): MarketRepository = repository

    @Provides
    @ViewModelScoped
    fun providesAnnouncementRepository(repository: AnnouncementRepositoryImpl): AnnouncementRepository = repository

    @Provides
    @ViewModelScoped
    fun providesUserRepository(repository: UserRepositoryImpl): UserRepository = repository
}