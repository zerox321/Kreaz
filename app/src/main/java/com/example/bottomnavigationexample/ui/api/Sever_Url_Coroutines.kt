package com.example.bottomnavigationexample.ui.api

import com.example.bottomnavigationexample.ui.api.ServerApis
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class Server_Url_Coroutines {

    var BASE_URL: String = "http://kreazdessert.com/api/"
    val getClient: ServerApis
        get() {

             val moshi = Moshi.Builder()
                .add(KotlinJsonAdapterFactory())
                .build()

             val retrofit  = Retrofit.Builder()
                .addConverterFactory(MoshiConverterFactory.create(moshi))
                .addCallAdapterFactory(CoroutineCallAdapterFactory())
                .baseUrl(BASE_URL)
                .build()




            return retrofit.create(ServerApis::class.java)

        }
}