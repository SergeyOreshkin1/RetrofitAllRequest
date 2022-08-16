package com.example.retrofitallrequest.di

import androidx.viewbinding.BuildConfig
import com.example.retrofitallrequest.data.api.ApiService
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class NetworkModule {

    companion object {
        const val baseUrl = "https://dummy.restapiexample.com/api/v1/"
    }

    @Singleton
    @Provides
    fun providesRetrofit(): Retrofit {
        return Retrofit.Builder().baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create()).apply {
              //  if (BuildConfig.DEBUG) {
                    this.client(
                        OkHttpClient.Builder()
                        .addNetworkInterceptor(
                            HttpLoggingInterceptor().apply {
                                level = HttpLoggingInterceptor.Level.BODY
                            }
                        )
                        .build())
            //    }
            }.build()
    }

    @Singleton
    @Provides
    fun providesEmployeesAPI(retrofit: Retrofit): ApiService {
        return retrofit.create(ApiService::class.java)
    }
}
