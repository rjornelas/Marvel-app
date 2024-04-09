package com.rjornelas.marvelapp.framework.network.response

data class DataContainerResponse (
    val offset: Int,
    val total: Int,
    val results: List<CharacterResponse>
)