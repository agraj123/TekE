package com.example.teke

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.teke.Adapter.CartAdapter
import com.example.teke.Adapter.ProductAdapterThird
import com.example.teke.Product.ProductEntity
import com.example.teke.User.RegisterDatabase
import com.example.teke.databinding.ActivityCartBinding
import kotlinx.android.synthetic.main.activity_dashboard.*

class CartActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCartBinding
    lateinit var database: RegisterDatabase
    lateinit var arrayList: List<ProductEntity>
    lateinit var adapter: CartAdapter
    private lateinit var playAdapter: List<ProductEntity>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCartBinding.inflate(layoutInflater)
        setContentView(binding.root)

        database = RegisterDatabase.getInstance(this)
        arrayList = database.ProductDao().fetchSave()
        playAdapter =
            listOf(ProductEntity(0, null, "", "", "", "", 0, 0, 0, ""))

        val a = database.ProductDao().setFavData(1)
        Log.d("Cart", "onCreateView: $a[0]")
        adapter = CartAdapter(arrayList, this)
        binding.cartRecycler.setHasFixedSize(true)
        binding.cartRecycler.layoutManager = LinearLayoutManager(this)
        binding.cartRecycler.adapter = adapter

    }
}