package com.samuelalmeida.cryptocurrencyandroidcompose.di

import com.samuelalmeida.cryptocurrencyandroidcompose.common.Constants.BASE_URL
import com.samuelalmeida.cryptocurrencyandroidcompose.data.remote.CoinApi
import com.samuelalmeida.cryptocurrencyandroidcompose.data.repository.CoinRepositoryImpl
import com.samuelalmeida.cryptocurrencyandroidcompose.domain.repository.CoinRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun providePaprikaApi(): CoinApi {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CoinApi::class.java)
    }

    @Provides
    @Singleton
    fun provideCoinRepository(api: CoinApi): CoinRepository {
        return CoinRepositoryImpl(api)
    }
}