package com.rjornelas.marvelapp.framework.remote

import com.rjornelas.marvelapp.framework.network.MarvelApi
import com.rjornelas.marvelapp.framework.network.response.DataWrapperResponse
import com.rjornelas.core.data.repository.CharactersRemoteDataSource
import javax.inject.Inject

class RetrofitCharactersDataSource @Inject constructor(
    private val marvelApi: MarvelApi
) : CharactersRemoteDataSource<DataWrapperResponse> {

    override suspend fun fetchCharacters(queries: Map<String, String>): DataWrapperResponse {
        return marvelApi.getCharacters(queries)
    }
}