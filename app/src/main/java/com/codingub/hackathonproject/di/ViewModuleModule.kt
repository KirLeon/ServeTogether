package com.codingub.hackathonproject.di

import com.codingub.hackathonproject.data.repositories.AuthRepository
import com.codingub.hackathonproject.data.repositories.AuthRepositoryImpl
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

}