package com.example.bottomnavigationexample.ui.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.bottomnavigationexample.databinding.CategoryListRowBinding

class CategoryAdapter(private val listener: ClickListener) :
    ListAdapter<CategoryData, CategoryAdapter.StoreViewHolder>(DiffCallback) {

    companion object DiffCallback : DiffUtil.ItemCallback<CategoryData>() {
        override fun areItemsTheSame(oldItem: CategoryData, newItem: CategoryData): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: CategoryData, newItem: CategoryData): Boolean {
            return oldItem.id == newItem.id
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StoreViewHolder {
        return StoreViewHolder(
            CategoryListRowBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: StoreViewHolder, position: Int) {
        val marsProperty = getItem(position)
        holder.bind(marsProperty)
        holder.itemView.setOnClickListener { v ->
            listener.onRowClick(marsProperty, v)
        }

    }


    class StoreViewHolder(private var binding: CategoryListRowBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(category: CategoryData) {
            binding.category = category
            binding.executePendingBindings()
        }


    }


    interface ClickListener {
        fun onRowClick(category: CategoryData, v: View)
    }
}