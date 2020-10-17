package com.example.ensayoproductosapp.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.ensayoproductosapp.ProductViewModel
import com.example.ensayoproductosapp.R
import com.example.ensayoproductosapp.model.ProductRepository

class MainActivity : AppCompatActivity() {
    private lateinit var mViewModel : ProductViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mViewModel = ViewModelProvider(this).get(ProductViewModel::class.java)


    }
}