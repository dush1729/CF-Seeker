package com.example.cfseeker.di.module

import com.example.cfseeker.MyApplication
import com.example.cfseeker.data.remote.api.NetworkService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class ApplicationModule(private val application: MyApplication) {
    @Singleton
    @Provides
    fun provideNetworkService(): NetworkService {
        return Retrofit
            .Builder()
            .baseUrl("https://codeforces.com/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(NetworkService::class.java)
    }
}