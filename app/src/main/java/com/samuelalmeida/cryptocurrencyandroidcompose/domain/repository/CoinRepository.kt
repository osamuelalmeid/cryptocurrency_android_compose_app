package com.samuelalmeida.cryptocurrencyandroidcompose.domain.repository

import com.samuelalmeida.cryptocurrencyandroidcompose.data.remote.dto.CoinDetailDto
import com.samuelalmeida.cryptocurrencyandroidcompose.data.remote.dto.CoinDto

interface CoinRepository {

    suspend fun getCoins(): List<CoinDto>

    suspend fun getCoinById(coinId: String): CoinDetailDto

}