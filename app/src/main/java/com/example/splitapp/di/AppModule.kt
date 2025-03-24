package com.example.splitapp.di

import android.content.ContentResolver
import android.content.Context
import com.example.splitapp.data.repository.ContactRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    fun provideContentResolver(@ApplicationContext context: Context): ContentResolver {
        return context.contentResolver
    }

    @Singleton
    @Provides
    fun provideContactRepository(contentResolver: ContentResolver): ContactRepository {
        return ContactRepository(contentResolver)
    }
}