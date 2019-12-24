package com.example.bottomnavigationexample.ui.api



import com.example.bottomnavigationexample.ui.home.CategoryResponse
import kotlinx.coroutines.Deferred
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.*

interface ServerApis {




    @GET("index.php")
    fun getCategoriesAsync(
        @Query("mode") mode:String,
        @Query("type") type:String
    ): Deferred<CategoryResponse>



}