package com.example.gamecards.view.factionhorde

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.gamecards.R
import com.example.gamecards.data.domain.model.Card
import com.example.gamecards.databinding.ItemCardBinding
import javax.inject.Inject

/**
 * Igor Santos
 * 24/10/2022
 */

class FactionHordeAdapter @Inject constructor(
    private val viewModel: FactionHordeViewModel
) : ListAdapter<Card, FactionHordeAdapter.ChooseVH>(DiffCallback) {

    companion object {
        private val DiffCallback = object : DiffUtil.ItemCallback<Card>() {
            override fun areItemsTheSame(oldItem: Card, newItem: Card) =
                oldItem.dbfId == newItem.dbfId

            override fun areContentsTheSame(oldItem: Card, newItem: Card) = oldItem == newItem
        }
    }

    class ChooseVH(
        val binding: ItemCardBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun setup(card: Card, factionViewModel: FactionHordeViewModel) {
            binding.viewModel = factionViewModel
            binding.data = card
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChooseVH {
        return ChooseVH(
            ItemCardBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ChooseVH, position: Int) {
        val item = getItem(position)
        holder.setup(getItem(position), viewModel)

        holder.binding.iconCard.setOnClickListener {
            viewModel.onClickSelectCard(item.cardId)
        }
    }
}