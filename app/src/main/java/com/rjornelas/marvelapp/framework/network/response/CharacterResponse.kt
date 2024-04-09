package com.rjornelas.marvelapp.framework.network.response

import com.rjornelas.core.domain.model.Character

data class CharacterResponse (
    val id: String,
    val name: String,
    val thumbnail: ThumbnailResponse
)

fun CharacterResponse.toCharacterModel(): Character{
    return Character(
        name = this.name,
        imageUrl = "${this.thumbnail.path}.${this.thumbnail.extension}".replace("http", "https")
    )
}