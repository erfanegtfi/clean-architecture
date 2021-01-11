package com.clean.presentation.di


import androidx.annotation.NonNull
import com.clean.common.BASE_URL
import com.clean.data.dataSourse.api.ApiInterface
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.clean.data.utils.NetInterceptor
import com.clean.BuildConfig
import com.clean.common.REQUEST_TIMEOUT_DURATION
import com.clean.data.repository.ProductRepositoryImpl
import com.clean.domain.repository.ProductRepository
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.ExperimentalCoroutinesApi
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton


@Module
@ExperimentalCoroutinesApi
class AppModule {


    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient {

        return if (BuildConfig.DEBUG) {
            OkHttpClient.Builder()
                .addInterceptor(NetInterceptor())
                .connectTimeout(REQUEST_TIMEOUT_DURATION.toLong(), TimeUnit.SECONDS)
                .readTimeout(REQUEST_TIMEOUT_DURATION.toLong(), TimeUnit.SECONDS)
                .writeTimeout(REQUEST_TIMEOUT_DURATION.toLong(), TimeUnit.SECONDS)
                .build()
        } else {
            OkHttpClient.Builder()
                .addInterceptor(NetInterceptor())
                .connectTimeout(REQUEST_TIMEOUT_DURATION.toLong(), TimeUnit.SECONDS)
                .readTimeout(REQUEST_TIMEOUT_DURATION.toLong(), TimeUnit.SECONDS)
                .writeTimeout(REQUEST_TIMEOUT_DURATION.toLong(), TimeUnit.SECONDS)
                .build()
        }

    }


    @Provides
    @Singleton
    fun provideGson(): Gson {
        return GsonBuilder().enableComplexMapKeySerialization().setPrettyPrinting().create()
    }

    @Provides
    @Singleton
    fun provideProductRepository(productRepository: ProductRepositoryImpl): ProductRepository {
        return productRepository
    }


    @Provides
    @Singleton
    fun provideRetrofit(@NonNull okHttpClient: OkHttpClient, gson: Gson): Retrofit {

        return Retrofit.Builder().client(okHttpClient)
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addConverterFactory(GsonConverterFactory.create(gson))
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().serializeNulls().create()))
            .addConverterFactory(ScalarsConverterFactory.create())
//            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideApiService(retrofit: Retrofit): ApiInterface = retrofit.create(ApiInterface::class.java)

}