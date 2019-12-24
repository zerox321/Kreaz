package com.example.bottomnavigationexample.ui

import android.util.Log
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.example.bottomnavigationexample.ui.home.Item
import com.example.bottomnavigationexample.ui.homeDetail.ItemAdapter


@BindingAdapter("adapter")
fun setAdapter(view: RecyclerView, adapter: ListAdapter<*, *>) {
    view.adapter = adapter
}

@BindingAdapter("app:item_adapter", "app:items")
fun bind(recyclerView: RecyclerView, adapter: ItemAdapter?, data: List<Item>?) {
    recyclerView.adapter = adapter
    adapter!!.submitList(data)
}

@BindingAdapter("image")
fun loadImage(imageView: ImageView, url: String) {
    Glide.with(imageView.context)
        .load(url)
        .diskCacheStrategy(DiskCacheStrategy.DATA)
        .transition(DrawableTransitionOptions.withCrossFade())
        .into(imageView)

}