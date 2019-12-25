package com.example.bottomnavigationexample.api


import com.example.bottomnavigationexample.ui.dashboard.OfferResponse
import com.example.bottomnavigationexample.ui.home.CategoryResponse
import com.example.bottomnavigationexample.ui.notifications.BranchesData
import com.example.bottomnavigationexample.ui.notifications.BranchesResponse
import kotlinx.coroutines.Deferred
import retrofit2.http.*

interface ServerApis {


    @GET("index.php")
    fun getCategoriesAsync(
        @Query("mode") mode: String,
        @Query("type") type: String
    ): Deferred<CategoryResponse>

    @GET("index.php")
    fun getOffersAsync(
        @Query("mode") mode: String,
        @Query("type") type: String
    ): Deferred<OfferResponse>

    @GET("index.php")
    fun getBranchesAsync(
        @Query("mode") mode: String,
        @Query("type") type: String
    ): Deferred<BranchesResponse>



}