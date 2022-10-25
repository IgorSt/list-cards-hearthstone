package com.example.gamecards.view.cardselected

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.gamecards.R
import com.example.gamecards.data.domain.model.Card
import com.example.gamecards.databinding.ItemCardDetailsBinding

/**
 * Igor Santos
 * 25/10/2022
 */

class CardSelectedAdapter : ListAdapter<Card, CardSelectedAdapter.CardSelectedVH>(DiffCallback) {

    companion object {
        private val DiffCallback = object : DiffUtil.ItemCallback<Card>() {
            override fun areItemsTheSame(oldItem: Card, newItem: Card) = oldItem.dbfId == newItem.dbfId

            override fun areContentsTheSame(oldItem: Card, newItem: Card) = oldItem == newItem

        }
    }

    class CardSelectedVH(
        val binding: ItemCardDetailsBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun setup(card: Card) {
            binding.data = card
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardSelectedVH {
        return CardSelectedVH(
            ItemCardDetailsBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: CardSelectedVH, position: Int) {
        holder.setup(getItem(position))
    }
}