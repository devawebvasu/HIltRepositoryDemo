package com.retrofitapiimplementationwithhilt.Module

import android.content.Context
import androidx.room.Room
import com.retrofitapiimplementationwithhilt.db.FakerDB
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class DatabaseModule {

    @Singleton
    @Provides
    fun ProvidesDatabase(@ApplicationContext context: Context) : FakerDB{
        return Room.databaseBuilder(context,FakerDB::class.java,"Record")
            .allowMainThreadQueries()
            .build()
    }
}