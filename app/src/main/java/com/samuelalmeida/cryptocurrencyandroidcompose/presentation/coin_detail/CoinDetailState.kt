package com.samuelalmeida.cryptocurrencyandroidcompose.presentation.coin_detail

import com.samuelalmeida.cryptocurrencyandroidcompose.domain.model.CoinDetail

data class CoinDetailState(
    val isLoading: Boolean = false,
    val coin: CoinDetail? = null,
    val error: String = ""
)