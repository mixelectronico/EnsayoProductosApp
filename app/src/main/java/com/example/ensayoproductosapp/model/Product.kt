package com.example.ensayoproductosapp.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "productdatabase")
class Product (@PrimaryKey val id: Int,
               val name: String,
               val price: Int,
               val image: String,
               val description: String,
               val lastPrice: Int,
               val credit: Boolean)