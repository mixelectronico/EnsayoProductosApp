package com.example.ensayoproductosapp.model.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.ensayoproductosapp.model.Product

@Dao
interface DaoProduct {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveNewProducts(productList : List<Product>)

    @Query("SELECT * FROM productdatabase ORDER BY id ASC")
    fun getAllStoredProducts() : LiveData<List<Product>>
}