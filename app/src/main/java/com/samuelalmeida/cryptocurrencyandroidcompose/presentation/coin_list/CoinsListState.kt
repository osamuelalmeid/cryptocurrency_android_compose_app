package com.samuelalmeida.cryptocurrencyandroidcompose.presentation.coin_list

import com.samuelalmeida.cryptocurrencyandroidcompose.domain.model.Coin

data class CoinsListState(
    val isLoading: Boolean = false,
    val coins: List<Coin> = emptyList(),
    val error: String = ""
)