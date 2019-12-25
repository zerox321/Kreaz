package com.example.bottomnavigationexample.ui.home

import android.util.Log
import android.view.View
import androidx.databinding.ObservableBoolean
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.findNavController
import com.example.bottomnavigationexample.api.Server_Url_Coroutines
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.io.IOException

class HomeViewModel : ViewModel(), CategoryAdapter.ClickListener {


    private val tag = HomeViewModel::class.java.name


    val adapter: CategoryAdapter = CategoryAdapter(this)

    val isLoading: ObservableBoolean = ObservableBoolean()


    fun onRefresh() {

        callServer()

    }

    init {
        callServer()
    }


    private fun callServer() {
        isLoading.set(true)

        adapter.submitList(null)

        Log.e(tag, "callServer  Start")

        viewModelScope.launch {
            try {
                val response = getTasks()


                Log.e(tag, "callServer  ${response.type}")
                if (response.type == "success")
                    adapter.submitList(response.data)

                isLoading.set(false)


            } catch (ex: IOException) {
                isLoading.set(false)

                Log.e(tag, "callServer  ${ex.message}")

            }

        }
    }


    private suspend fun getTasks() =
        withContext(Dispatchers.IO) {
            Server_Url_Coroutines().getClient.getCategoriesAsync(
                "get",
                "categories"

            ).await()
        }

    override fun onRowClick(category: CategoryData, v: View) {
        v.findNavController().navigate(HomeFragmentDirections.homeToDetail(category))
    }
}