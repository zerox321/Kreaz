package com.example.bottomnavigationexample.ui.home.homeDetail

import android.view.View
import androidx.lifecycle.ViewModel
import com.example.bottomnavigationexample.ui.home.Item

class HomeDetailViewModel : ViewModel(), ItemAdapter.ClickListener{
    override fun onRowClick(category: Item, v: View) {
    }


    val adapter: ItemAdapter = ItemAdapter(this)

}
