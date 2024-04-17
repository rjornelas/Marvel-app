package com.rjornelas.testing.model

import com.rjornelas.core.domain.model.Comic

class ComicFactory {

    fun create(comic: FakeComic) = when (comic) {
        FakeComic.FakeComic1 -> Comic(
            2211506,
            "http://fakecomigurl.jpg"
        )
    }

    sealed class FakeComic {
        data object FakeComic1 : FakeComic()
    }
}