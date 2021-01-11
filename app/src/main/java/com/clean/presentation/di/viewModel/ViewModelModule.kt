package com.clean.presentation.di.viewModel

import androidx.lifecycle.ViewModel
import com.clean.presentation.di.ViewModelKey
import com.clean.presentation.product.ProductViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import kotlinx.coroutines.ExperimentalCoroutinesApi


@Suppress("unused")
@Module
//internal
abstract class ViewModelModule {

    @ExperimentalCoroutinesApi
    @Binds
    @IntoMap
    @ViewModelKey(ProductViewModel::class)
    abstract fun bindBookViewModelFlow(libraryViewModel: ProductViewModel): ViewModel

}