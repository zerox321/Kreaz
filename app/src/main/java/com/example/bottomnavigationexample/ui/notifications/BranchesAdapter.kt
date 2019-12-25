package com.example.bottomnavigationexample.ui.notifications

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.bottomnavigationexample.databinding.BranchListRowBinding
import com.example.bottomnavigationexample.databinding.CategoryListRowBinding

class BranchesAdapter(private val listener: ClickListener) :
    ListAdapter<BranchesData, BranchesAdapter.StoreViewHolder>(DiffCallback) {

    companion object DiffCallback : DiffUtil.ItemCallback<BranchesData>() {
        override fun areItemsTheSame(oldItem: BranchesData, newItem: BranchesData): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: BranchesData, newItem: BranchesData): Boolean {
            return oldItem.name == newItem.name
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StoreViewHolder {
        return StoreViewHolder(
            BranchListRowBinding.inflate(
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


    class StoreViewHolder(private var binding: BranchListRowBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(branch: BranchesData) {
            binding.branch = branch
            binding.executePendingBindings()
        }


    }


    interface ClickListener {
        fun onRowClick(branch: BranchesData, v: View)
    }
}