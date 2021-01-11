package com.clean.common

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide



@BindingAdapter("image_url")
fun ImageView.loadImage(imageUrl: String?) {
    imageUrl?.let {
        Glide
            .with(context)
            .load(imageUrl)
//        .centerCrop()
//            .placeholder(R.drawable.bg_header_bubble)
            .into(this)
    }

}
