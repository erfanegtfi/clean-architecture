package com.clean.presentation.di

import android.app.Application
import androidx.annotation.NonNull
import com.clean.data.dataSourse.local.dao.ProductDao
import com.clean.data.dataSourse.local.CleanDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class PersistenceModule {

//
    @Provides
    @Singleton
    fun provideBookDao(@NonNull database: CleanDatabase): ProductDao {
        return database.getProductDao()
    }

    @Provides
    @Singleton
    fun provideDatabase(@NonNull application: Application): CleanDatabase {
        return CleanDatabase.getInstance(application)
    }


}