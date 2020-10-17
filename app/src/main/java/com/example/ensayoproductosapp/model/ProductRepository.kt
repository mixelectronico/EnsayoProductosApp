package com.example.ensayoproductosapp.model

import android.content.Context
import android.util.Log
import androidx.lifecycle.LiveData
import com.example.eartquakehistory.model.API.ProductRetrofitClient
import com.example.ensayoproductosapp.model.database.ProductDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ProductRepository(context: Context) {
    private val db : ProductDatabase = ProductDatabase.getProductDatabase(context)
    private val listOfEvents : LiveData<List<Product>> = db.daoProduct().getAllStoredProducts()

    fun bringListOfProductsToViewModel() : LiveData<List<Product>>{
        return listOfEvents
    }

    fun getProductListFromAPI(){
        ProductRetrofitClient.retrofitInstance().getListOfProducts().enqueue(object : Callback<List<Product>>{
            override fun onResponse(call: Call<List<Product>>, response: Response<List<Product>>) {
                CoroutineScope(Dispatchers.IO).launch {
                    response.body()?.let {
                        db.daoProduct().saveNewProducts(it)
                    }
                }
            }

            override fun onFailure(call: Call<List<Product>>, t: Throwable) {
                Log.e("ERROR", t.toString())
            }
        })
    }

    fun getDetailedProductFromAPI(id:Int){
        ProductRetrofitClient.retrofitInstance().getProductDetails(id).enqueue(object : Callback<Product>{
            override fun onResponse(call: Call<Product>, response: Response<Product>) {
                Log.d("DETALLE",response.body().toString())
            }

            override fun onFailure(call: Call<Product>, t: Throwable) {
                Log.e("ERROR", t.toString())
            }

        })
    }

}