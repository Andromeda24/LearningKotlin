package org.ll.lab5_2.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import org.ll.lab5_2.model.ABRepository
import org.ll.lab5_2.model.ABRepositoryImpl
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    //@Provides
    //@Singleton
    //fun provideABRepository(): ABRepository {
    //    return ABRepositoryImpl()
    //}

}