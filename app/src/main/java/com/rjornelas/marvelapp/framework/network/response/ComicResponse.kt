package com.rjornelas.marvelapp.framework.network.response

import com.google.gson.annotations.SerializedName
import com.rjornelas.core.domain.domain.model.Comic

data class ComicResponse(
    @SerializedName("id")
    val id: Int,
    @SerializedName("thumbnail")
    val thumbnail: ThumbnailResponse
)

fun ComicResponse.toComicModel(): Comic {
    return Comic(
        id = this.id,
        imageUrl = this.thumbnail.getHttpsUrl()
    )
}
