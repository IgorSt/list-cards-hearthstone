package com.example.gamecards.data.rules

import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.example.gamecards.R
import com.google.android.material.textview.MaterialTextView

/**
 * Igor Santos
 * 25/10/2022
 */

@BindingAdapter("visibleIf")
fun visibleIf(view: View, state: Boolean) {
    view.visibility = if (state) View.VISIBLE else View.GONE
}

@BindingAdapter("goneIf")
fun MaterialTextView.goneIf(value: String?) {
    visibility = if (value.isNullOrEmpty()) { View.GONE } else { View.VISIBLE }
}

@BindingAdapter("imageUrl")
fun ImageView.imageUrl(url: String?) {
    Glide.with(context)
        .load(url)
        .error(R.drawable.ic_nothing_found)
        .into(this)
}