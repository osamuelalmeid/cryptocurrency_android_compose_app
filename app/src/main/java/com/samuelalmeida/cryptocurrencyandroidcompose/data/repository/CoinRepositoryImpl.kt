package com.samuelalmeida.cryptocurrencyandroidcompose.data.repository

import com.samuelalmeida.cryptocurrencyandroidcompose.data.remote.dto.CoinDetailDto
import com.samuelalmeida.cryptocurrencyandroidcompose.data.remote.dto.CoinDto
import com.samuelalmeida.cryptocurrencyandroidcompose.domain.repository.CoinRepository
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(
    private val api: CoinPaprikaAPI
) : CoinRepository {

    override suspend fun getCoins(): List<CoinDto> {
        return api.getCoins()
    }

    override suspend fun getCoinById(coinId: String): CoinDetailDto {
        return api.getCoinById(coinId)
    }
}