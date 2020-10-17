package com.example.ensayoproductosapp

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.ensayoproductosapp.model.Product
import com.example.ensayoproductosapp.model.ProductRepository

class ProductViewModel(application: Application): AndroidViewModel(application) {
    private val repository = ProductRepository(application)
    private val listOfProducts: LiveData<List<Product>> = repository.bringListOfProductsToViewModel()

    fun bringListOfProductsToView() :  LiveData<List<Product>> {
        return listOfProducts
    }

    fun requestProductList(){
        repository.getProductListFromAPI()
    }
}