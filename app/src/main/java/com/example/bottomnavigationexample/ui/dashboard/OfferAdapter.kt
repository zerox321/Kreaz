package com.example.bottomnavigationexample.ui.dashboard

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.bottomnavigationexample.databinding.CategoryListRowBinding
import com.example.bottomnavigationexample.databinding.OfferListRowBinding

class OfferAdapter(private val listener: ClickListener) :
    ListAdapter<OfferData, OfferAdapter.StoreViewHolder>(DiffCallback) {

    companion object DiffCallback : DiffUtil.ItemCallback<OfferData>() {
        override fun areItemsTheSame(oldItem: OfferData, newItem: OfferData): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: OfferData, newItem: OfferData): Boolean {
            return oldItem.offerId == newItem.offerId
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StoreViewHolder {
        return StoreViewHolder(
            OfferListRowBinding.inflate(
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


    class StoreViewHolder(private var binding: OfferListRowBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(offer: OfferData) {
            binding.offer = offer
            binding.executePendingBindings()
        }


    }


    interface ClickListener {
        fun onRowClick(offer: OfferData, v: View)
    }
}