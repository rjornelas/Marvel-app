package com.rjornelas.testing.model

import com.rjornelas.core.domain.model.Character

class CharacterFactory {

    fun create(hero: Hero) = when (hero) {
        Hero.ThreeDMan -> Character(
            1011334,
            "3-D Man",
            "https://i.annihil.us/u/prod/marvel/i/mg/c/e0/535fecbbb9784.jpg"
        )
        Hero.ABomb -> Character(
            1017100,
            "A-Bomb (HAS)",
            "https://i.annihil.us/u/prod/marvel/i/mg/3/20/5232158de5b16.jpg"
        )
    }

    sealed class Hero {
        object ThreeDMan : Hero()
        object ABomb : Hero()
    }
}