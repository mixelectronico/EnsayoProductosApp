package com.example.ensayoproductosapp.model.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.ensayoproductosapp.model.Product

@Database(entities = [Product::class], version = 1)
abstract class ProductDatabase : RoomDatabase() {
    abstract fun daoProduct() : DaoProduct
    companion object{
        @Volatile
        private var INSTANCE : ProductDatabase? = null

        fun getProductDatabase(context: Context): ProductDatabase{
            val tempInstance = INSTANCE
            if (tempInstance != null){
                return tempInstance
            }
            synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    ProductDatabase::class.java,
                    "productos").build()
                INSTANCE = instance
                return instance
            }
        }
    }
}