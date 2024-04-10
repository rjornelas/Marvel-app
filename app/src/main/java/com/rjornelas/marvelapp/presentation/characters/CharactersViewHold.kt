package com.rjornelas.marvelapp.presentation.characters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.rjornelas.core.domain.model.Character
import com.rjornelas.marvelapp.R
import com.rjornelas.marvelapp.databinding.ItemCharacterBinding

class CharactersViewHold(itemCharacterBinding: ItemCharacterBinding) :
    RecyclerView.ViewHolder(itemCharacterBinding.root) {

    private val textName = itemCharacterBinding.txtName
    private val imageCharacter = itemCharacterBinding.imageCharacter

    fun bind(character: Character) {
        textName.text = character.name
        Glide.with(itemView)
            .load(character.imageUrl)
            .fallback(R.drawable.ic_img_loading_error)
            .into(imageCharacter)
    }

    companion object{
        fun create(parent: ViewGroup) : CharactersViewHold {
            val inflater = LayoutInflater.from(parent.context)
            val itemBinding = ItemCharacterBinding.inflate(inflater, parent, false)
            return CharactersViewHold(itemBinding)
        }
    }
}