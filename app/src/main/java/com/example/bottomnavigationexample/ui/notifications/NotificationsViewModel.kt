package com.example.bottomnavigationexample.ui.notifications

import android.util.Log
import android.view.View
import androidx.databinding.ObservableBoolean
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.findNavController
import com.example.bottomnavigationexample.api.Server_Url_Coroutines
import com.example.bottomnavigationexample.ui.home.CategoryAdapter
import com.example.bottomnavigationexample.ui.home.CategoryData
import com.example.bottomnavigationexample.ui.home.HomeFragmentDirections
import com.example.bottomnavigationexample.ui.home.HomeViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.io.IOException

class NotificationsViewModel : ViewModel() , BranchesAdapter.ClickListener {
    override fun onRowClick(branch: BranchesData, v: View) {

    }


    private val tag = NotificationsViewModel::class.java.name


    val adapter: BranchesAdapter = BranchesAdapter(this)

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
            Server_Url_Coroutines().getClient.getBranchesAsync(
                "get",
                "branches"

            ).await()
        }


}