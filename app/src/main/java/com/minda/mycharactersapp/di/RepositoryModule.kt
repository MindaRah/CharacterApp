package com.minda.mycharactersapp.di

import com.minda.mycharactersapp.repository.CharacterRepositoryImpl
import com.minda.mycharactersapp.repository.CharactersRepo
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class RepositoryModule {
    @Binds
    abstract fun provideCharacterRepository(characterRepositoryImpl: CharacterRepositoryImpl): CharactersRepo
}