package com.huseyinkiran.cryptocurrency.data.repository

import com.huseyinkiran.cryptocurrency.data.remote.CoinPaprikaApi
import com.huseyinkiran.cryptocurrency.data.remote.dto.CoinDetailDto
import com.huseyinkiran.cryptocurrency.data.remote.dto.CoinDto
import com.huseyinkiran.cryptocurrency.domain.repository.CoinRepository
import dagger.hilt.android.HiltAndroidApp
import javax.inject.Inject

class CoinRepositoryImplementation @Inject constructor(
    private val api: CoinPaprikaApi
) : CoinRepository {

    override suspend fun getCoins(): List<CoinDto> {
        return api.getCoins()
    }

    override suspend fun getCoinById(coinId: String): CoinDetailDto {
        return api.getCoinById(coinId)
    }

}