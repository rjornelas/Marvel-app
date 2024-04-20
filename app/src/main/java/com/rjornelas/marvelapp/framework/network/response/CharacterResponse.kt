package com.rjornelas.marvelapp.framework.network.response

import com.google.gson.annotations.SerializedName
import com.rjornelas.core.domain.domain.model.Character

data class CharacterResponse(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("thumbnail")
    val thumbnail: ThumbnailResponse
)

fun CharacterResponse.toCharacterModel(): Character {
    return Character(
        id = this.id,
        name = this.name,
        imageUrl = this.thumbnail.getHttpsUrl()
    )
}
