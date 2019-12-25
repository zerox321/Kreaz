package com.example.bottomnavigationexample.api


import com.example.bottomnavigationexample.ui.dashboard.OfferResponse
import com.example.bottomnavigationexample.ui.home.CategoryResponse
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


}