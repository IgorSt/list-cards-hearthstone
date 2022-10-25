package com.example.gamecards.data.domain.model

import com.google.gson.annotations.SerializedName

/**
 * Igor Santos
 * 24/10/2022
 */

data class Card(
    val cardId: String,
    val dbfId: Int,
    val name: String,
    val cardSet: String,
    val type: String,
    val faction: String,
    @SerializedName("img")
    val image: String,
    val rarity: String,
    val cost: Int,
    val attack: Int,
    val health: Int,
    @SerializedName("text")
    val title: String,
    @SerializedName("flavor")
    val subtitle: String
)
