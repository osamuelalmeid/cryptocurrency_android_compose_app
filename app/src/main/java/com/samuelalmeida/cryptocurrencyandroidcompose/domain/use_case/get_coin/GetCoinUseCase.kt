package com.samuelalmeida.cryptocurrencyandroidcompose.domain.use_case.get_coin

import com.samuelalmeida.cryptocurrencyandroidcompose.common.Constants.MESSAGE_ERROR_CONNECTION
import com.samuelalmeida.cryptocurrencyandroidcompose.common.Constants.MESSAGE_ERROR_UNEXPECTED
import com.samuelalmeida.cryptocurrencyandroidcompose.common.Resource
import com.samuelalmeida.cryptocurrencyandroidcompose.data.remote.dto.toCoinDetail
import com.samuelalmeida.cryptocurrencyandroidcompose.domain.model.CoinDetail
import com.samuelalmeida.cryptocurrencyandroidcompose.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinUseCase @Inject constructor(
    private val repository: CoinRepository
) {
    operator fun invoke(coinId: String): Flow<Resource<CoinDetail>> = flow {
        try {
            emit(Resource.Loading<CoinDetail>())
            val coin = repository.getCoinById(coinId).toCoinDetail()
            emit(Resource.Success<CoinDetail>(coin))
        } catch (e: HttpException) {
            emit(Resource.Error<CoinDetail>(e.localizedMessage ?: MESSAGE_ERROR_UNEXPECTED))
        } catch (e: IOException) {
            emit(Resource.Error<CoinDetail>(MESSAGE_ERROR_CONNECTION))
        }
    }
}