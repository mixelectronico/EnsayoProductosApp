package com.example.eartquakehistory.model.API

import com.example.ensayoproductosapp.model.Product
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiProduct {
    @GET("products/")
    fun getListOfProducts(): Call<List<Product>>

    @GET("details/{id}")
    fun getProductDetails(@Path("id") id: Int): Call<Product>
}