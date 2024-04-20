package com.rjornelas.core.domain.domain.model

import com.rjornelas.core.domain.domain.model.Character

data class CharacterPaging(
    val offset: Int,
    val total: Int,
    val characters: List<Character>
)
