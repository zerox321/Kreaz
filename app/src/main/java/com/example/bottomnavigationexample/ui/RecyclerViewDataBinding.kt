package com.example.bottomnavigationexample.ui

import android.util.Log
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions


@BindingAdapter("adapter")
fun setAdapter(view: RecyclerView, adapter: ListAdapter<*, *>) {
    view.adapter = adapter
}

@BindingAdapter("image")
fun loadImage(imageView: ImageView, url: String) {
    Glide.with(imageView.context)
        .load(url)
        .diskCacheStrategy(DiskCacheStrategy.DATA)
        .transition(DrawableTransitionOptions.withCrossFade())
        .into(imageView)

}