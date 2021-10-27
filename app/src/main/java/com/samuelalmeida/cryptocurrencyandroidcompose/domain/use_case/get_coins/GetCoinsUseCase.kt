package com.samuelalmeida.cryptocurrencyandroidcompose.domain.use_case.get_coins

import com.samuelalmeida.cryptocurrencyandroidcompose.common.Constants.MESSAGE_ERROR_CONNECTION
import com.samuelalmeida.cryptocurrencyandroidcompose.common.Constants.MESSAGE_ERROR_UNEXPECTED
import com.samuelalmeida.cryptocurrencyandroidcompose.common.Resource
import com.samuelalmeida.cryptocurrencyandroidcompose.data.remote.dto.toCoin
import com.samuelalmeida.cryptocurrencyandroidcompose.domain.model.Coin
import com.samuelalmeida.cryptocurrencyandroidcompose.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinsUseCase @Inject constructor(
    private val repository: CoinRepository
) {
    operator fun invoke(): Flow<Resource<List<Coin>>> = flow {
        try {
            emit(Resource.Loading<List<Coin>>())
            val coins = repository.getCoins().map { it.toCoin() }
            emit(Resource.Success<List<Coin>>(coins))
        } catch (e: HttpException) {
            emit(Resource.Error<List<Coin>>(e.localizedMessage ?: MESSAGE_ERROR_UNEXPECTED))
        } catch (e: IOException) {
            emit(Resource.Error<List<Coin>>(MESSAGE_ERROR_CONNECTION))
        }
    }
}