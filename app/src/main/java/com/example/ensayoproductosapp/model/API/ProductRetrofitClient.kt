package com.example.eartquakehistory.model.API

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ProductRetrofitClient {
    companion object{
        private const val BASE_URL = "http://my-json-server.typicode.com/Himuravidal/FakeAPIdata/"
        fun retrofitInstance():ApiProduct {
            val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            return retrofit.create(ApiProduct::class.java)
        }
    }
}