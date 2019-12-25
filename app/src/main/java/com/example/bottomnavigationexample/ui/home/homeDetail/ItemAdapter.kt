package com.example.bottomnavigationexample.ui.home.homeDetail

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.bottomnavigationexample.databinding.ItemListRowBinding
import com.example.bottomnavigationexample.ui.home.Item

class ItemAdapter(private val listener: ClickListener) :
    ListAdapter<Item, ItemAdapter.StoreViewHolder>(DiffCallback) {

    companion object DiffCallback : DiffUtil.ItemCallback<Item>() {
        override fun areItemsTheSame(oldItem: Item, newItem: Item): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: Item, newItem: Item): Boolean {
            return oldItem.id == newItem.id
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StoreViewHolder {
        return StoreViewHolder(
            ItemListRowBinding.inflate(
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


    class StoreViewHolder(private var binding: ItemListRowBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Item) {
            binding.item = item
            binding.executePendingBindings()
        }


    }


    interface ClickListener {
        fun onRowClick(category: Item, v: View)
    }
}