package com.codingub.hackathonproject.data.repositories

import com.codingub.hackathonproject.data.remote.responses.GetMarketResponse
import com.codingub.hackathonproject.network.ServerResponse
import javax.inject.Inject

interface MarketRepository{

    suspend fun getMarkets() : ServerResponse<List<GetMarketResponse>>
}

class MarketRepositoryImpl @Inject constructor(

) : MarketRepository{

    override suspend fun getMarkets(): ServerResponse<List<GetMarketResponse>> {
        TODO("Not yet implemented")
    }
}