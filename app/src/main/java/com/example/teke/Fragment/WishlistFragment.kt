package com.example.teke.Fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.teke.Adapter.ProductAdapterThird
import com.example.teke.Adapter.WishlistAdapter
import com.example.teke.Product.ProductEntity
import com.example.teke.R
import com.example.teke.User.RegisterDatabase
import com.example.teke.databinding.ActivityCartBinding
import com.example.teke.databinding.FragmentWishlistBinding
import kotlinx.android.synthetic.main.activity_splash_screen.*

class WishlistFragment : Fragment() {

    lateinit var binding: FragmentWishlistBinding
    lateinit var database: RegisterDatabase
    lateinit var arrayList: List<ProductEntity>
    lateinit var adapter: ProductAdapterThird
    private lateinit var playAdapter: List<ProductEntity>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentWishlistBinding.inflate(layoutInflater, container, false)

        database = RegisterDatabase.getInstance(requireContext())
        arrayList = database.ProductDao().fetchWish()
        playAdapter = listOf(ProductEntity(0, null, "", "", "", "", 0, 0, 0, "",0))

        val a = database.ProductDao().setWishData(1)
        Log.d("Fav", "onCreateView: $a[0]")
        adapter = ProductAdapterThird(arrayList, requireContext())
        binding.wishlistRecycler.setHasFixedSize(true)
        binding.wishlistRecycler.layoutManager = LinearLayoutManager(requireContext())
        binding.wishlistRecycler.adapter = adapter

        return binding.root
    }

}