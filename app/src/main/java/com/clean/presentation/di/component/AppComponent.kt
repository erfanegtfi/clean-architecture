package com.clean.presentation.di.component

import android.app.Application
import androidx.lifecycle.ViewModelProvider
import com.clean.presentation.product.ProductListActivity
import com.clean.data.dataSourse.api.ApiInterface
import com.clean.data.dataSourse.local.dao.ProductDao
import com.clean.presentation.App
import com.google.gson.Gson
import com.clean.presentation.di.AppModule
import com.clean.presentation.di.PersistenceModule
import com.clean.presentation.di.viewModel.ViewModelFactoryModule
import com.clean.presentation.di.viewModel.ViewModelModule
import com.clean.data.dataSourse.local.CleanDatabase
import com.clean.domain.repository.ProductRepository
import dagger.BindsInstance
import dagger.Component
import kotlinx.coroutines.ExperimentalCoroutinesApi
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import javax.inject.Singleton

@ExperimentalCoroutinesApi
@Singleton
@Component(
    modules = [AppModule::class, ViewModelFactoryModule::class, ViewModelModule::class, PersistenceModule::class] //
)
interface AppComponent {
    fun inject(app: App)
    fun inject(mainActivity: ProductListActivity)

    fun provideApiService(): ApiInterface
    fun provideRetrofit(): Retrofit
    fun provideOkHttpClient(): OkHttpClient
    fun provideGson(): Gson

    fun provideBookDao(): ProductDao
    fun provideDatabase(): CleanDatabase
    fun bindViewModelFactory(): ViewModelProvider.Factory
    fun provideProductRepository(): ProductRepository
    fun applicationContext(): Application
//    fun context(): Context


    @Component.Factory
    interface Factory {
        fun create(@BindsInstance application: Application): AppComponent
    }
}