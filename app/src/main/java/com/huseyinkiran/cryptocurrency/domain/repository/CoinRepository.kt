package com.huseyinkiran.cryptocurrency.domain.repository

import com.huseyinkiran.cryptocurrency.data.remote.dto.CoinDetailDto
import com.huseyinkiran.cryptocurrency.data.remote.dto.CoinDto

interface CoinRepository {

    suspend fun getCoins() : List<CoinDto>

    suspend fun getCoinById(coinId: String) : CoinDetailDto

}