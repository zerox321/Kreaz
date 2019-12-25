package com.example.bottomnavigationexample.ui.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.bottomnavigationexample.databinding.CategoryListRowBinding
import com.example.bottomnavigationexample.databinding.MainCategoryListRowBinding

class CategoryAdapter(private val listener: ClickListener) :
    ListAdapter<CategoryData, RecyclerView.ViewHolder>(DiffCallback) {

    companion object DiffCallback : DiffUtil.ItemCallback<CategoryData>() {
        override fun areItemsTheSame(oldItem: CategoryData, newItem: CategoryData): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: CategoryData, newItem: CategoryData): Boolean {
            return oldItem.id == newItem.id
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return if(viewType==0)
            MainViewHolder(
                MainCategoryListRowBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )
        else SecondViewHolder(
            CategoryListRowBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )



    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val marsProperty = getItem(position)

        if (holder.itemViewType == 0) (holder as MainViewHolder).bind(marsProperty)
        else (holder as SecondViewHolder).bind(marsProperty)



        holder.itemView.setOnClickListener { v ->
            listener.onRowClick(marsProperty, v)
        }
    }

    override fun getItemViewType(position: Int): Int {
        // Just as an example, return 0 or 2 depending on position
        return position % 2
    }

    class SecondViewHolder(private var binding: CategoryListRowBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(category: CategoryData) {
            binding.category = category
            binding.executePendingBindings()
        }
    }

    class MainViewHolder(private var binding: MainCategoryListRowBinding) :
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