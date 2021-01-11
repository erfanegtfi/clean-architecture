package com.clean.presentation.di.viewModel

import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module

@Suppress("unused")
@Module
//internal
abstract class ViewModelFactoryModule {


    @Binds
    abstract fun bindViewModelFactory(appViewModelFactory: AppViewModelFactory): ViewModelProvider.Factory
}