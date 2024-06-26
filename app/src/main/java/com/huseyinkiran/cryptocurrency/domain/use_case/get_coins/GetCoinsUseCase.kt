package com.huseyinkiran.cryptocurrency.domain.use_case.get_coins

import android.net.http.HttpException
import android.os.Build
import android.os.ext.SdkExtensions
import com.huseyinkiran.cryptocurrency.common.Resource
import com.huseyinkiran.cryptocurrency.data.remote.dto.toCoin
import com.huseyinkiran.cryptocurrency.domain.model.Coin
import com.huseyinkiran.cryptocurrency.domain.model.CoinDetail
import com.huseyinkiran.cryptocurrency.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.IOException
import javax.inject.Inject

class GetCoinsUseCase @Inject constructor(
    private val repository: CoinRepository
) {
    operator fun invoke() : Flow<Resource<List<Coin>>> = flow {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R && SdkExtensions.getExtensionVersion(
                Build.VERSION_CODES.S) >= 7) {
            try {
                emit(Resource.Loading<List<Coin>>())
                val coins = repository.getCoins().map { it.toCoin() }
                emit(Resource.Success<List<Coin>>(coins))
            } catch (e: HttpException) {
                emit(Resource.Error<List<Coin>>(e.localizedMessage ?: "An unexpected error occured"))
            } catch (e: IOException) {
                emit(Resource.Error<List<Coin>>("Couldn't reach server. Check your internet connection"))
            }
        }
    }
}