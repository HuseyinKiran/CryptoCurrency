package com.huseyinkiran.cryptocurrency.di

import com.huseyinkiran.cryptocurrency.common.Constants.BASE_URL
import com.huseyinkiran.cryptocurrency.data.remote.CoinPaprikaApi
import com.huseyinkiran.cryptocurrency.data.repository.CoinRepositoryImplementation
import com.huseyinkiran.cryptocurrency.domain.repository.CoinRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun providePaprikaApi(): CoinPaprikaApi {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CoinPaprikaApi::class.java)
    }

    @Provides
    @Singleton
    fun provideCoinRepository(api: CoinPaprikaApi): CoinRepository {
        return CoinRepositoryImplementation(api)
    }

}