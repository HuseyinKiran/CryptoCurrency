package com.huseyinkiran.cryptocurrency.presentation.coin_detail

import com.huseyinkiran.cryptocurrency.domain.model.CoinDetail

data class CoinDetailState(
    val isLoading: Boolean = false,
    val coin: CoinDetail? = null,
    val error: String = ""
)
