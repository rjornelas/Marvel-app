package com.rjornelas.marvelapp.presentation.characters

import android.view.ViewGroup
import androidx.paging.LoadState
import androidx.paging.LoadStateAdapter

class CharactersLoadStateAdapter(
    private val retry: () -> Unit
) : LoadStateAdapter<CharactersLoadMoreStateViewHolder>() {

    override fun onBindViewHolder(holder: CharactersLoadMoreStateViewHolder, loadState: LoadState) {
        return holder.bind(loadState)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        loadState: LoadState
    ): CharactersLoadMoreStateViewHolder {
        return CharactersLoadMoreStateViewHolder.create(parent, retry)
    }
}