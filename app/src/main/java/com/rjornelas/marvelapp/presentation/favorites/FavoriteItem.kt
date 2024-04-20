package com.rjornelas.marvelapp.presentation.favorites

import com.rjornelas.marvelapp.presentation.common.ListItem

data class FavoriteItem(
    val id: Int,
    val name: String,
    val imageUrl: String,
    override val key: Long = id.toLong()
) : ListItem
