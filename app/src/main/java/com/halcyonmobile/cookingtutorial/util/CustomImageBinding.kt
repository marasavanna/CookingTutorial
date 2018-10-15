package com.halcyonmobile.cookingtutorial.util

import android.databinding.BindingAdapter
import android.widget.ImageView
import com.halcyonmobile.cookingtutorial.GlideApp

object CustomImageBinding {

    @JvmStatic
    @BindingAdapter("android:src")
    fun setImageUrl(imageView: ImageView, imageUrl: String) {
        GlideApp.with(imageView.context).load(imageUrl)
                .centerCrop()
                .into(imageView)
    }
}