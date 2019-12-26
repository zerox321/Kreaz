package com.example.bottomnavigationexample.ui.home.homeDetail

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.bottomnavigationexample.databinding.ItemListRowBinding
import com.example.bottomnavigationexample.databinding.MainItemListRowBinding
import com.example.bottomnavigationexample.ui.home.Item

class ItemAdapter(private val listener: ClickListener) :
    ListAdapter<Item, RecyclerView.ViewHolder>(DiffCallback) {

    companion object DiffCallback : DiffUtil.ItemCallback<Item>() {
        override fun areItemsTheSame(oldItem: Item, newItem: Item): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: Item, newItem: Item): Boolean {
            return oldItem.id == newItem.id
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return if(viewType==0)
            MainViewHolder(
                MainItemListRowBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )
        else SecondViewHolder(
            ItemListRowBinding.inflate(
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




    class MainViewHolder(private var binding: MainItemListRowBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Item) {
            binding.item = item
            binding.executePendingBindings()
        }
    }
    class SecondViewHolder(private var binding: ItemListRowBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Item) {
            binding.item = item
            binding.executePendingBindings()
        }
    }

    override fun getItemViewType(position: Int): Int {
        // Just as an example, return 0 or 2 depending on position
        return position % 2
    }

    interface ClickListener {
        fun onRowClick(category: Item, v: View)
    }
}