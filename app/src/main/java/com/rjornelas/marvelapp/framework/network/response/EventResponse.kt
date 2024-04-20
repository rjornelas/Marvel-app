package com.rjornelas.marvelapp.framework.network.response

import com.google.gson.annotations.SerializedName
import com.rjornelas.core.domain.domain.model.Event

data class EventResponse(
    @SerializedName("id")
    val id: Int,
    @SerializedName("thumbnail")
    val thumbnail: ThumbnailResponse
)

fun EventResponse.toEventModel(): Event {
    return Event(
        id = this.id,
        imageUrl = this.thumbnail.getHttpsUrl()
    )
}
