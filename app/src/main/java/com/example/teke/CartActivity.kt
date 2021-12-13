package com.example.teke

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.teke.Adapter.CartAdapter
import com.example.teke.Adapter.ProductAdapterThird
import com.example.teke.Product.ProductEntity
import com.example.teke.User.RegisterDatabase
import com.example.teke.ViewModel.CartViewModel
import com.example.teke.databinding.ActivityCartBinding
import kotlinx.android.synthetic.main.activity_dashboard.*
import java.util.EnumSet.of
import java.util.List.of
import java.util.Set.of

class CartActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCartBinding
    lateinit var database: RegisterDatabase
    lateinit var arrayList: List<ProductEntity>
    lateinit var adapter: CartAdapter
    private lateinit var playAdapter: List<ProductEntity>

//    private val cartViewModel: CartViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCartBinding.inflate(layoutInflater)
        setContentView(binding.root)

        database = RegisterDatabase.getInstance(this)
        arrayList = database.ProductDao().fetchSave()
        playAdapter =
            listOf(ProductEntity(0, null, "", "", "", "", 0, 0, 0, "", 0))

        val a = database.ProductDao().setFavData(1)
        Log.d("Cart", "onCreateView: $a[0]")
        adapter = CartAdapter(arrayList, this)
        binding.cartRecycler.setHasFixedSize(true)
        binding.cartRecycler.layoutManager = LinearLayoutManager(this)
        binding.cartRecycler.adapter = adapter

        binding.cartPlaceOrderBtn.setOnClickListener {



//            val cartData = arrayList[0].cart_order
//            Log.d("TAG", "onBindViewHolder: $cartData")
//
//            if (cartData == 1) {
//                val cartUpdate = ProductEntity(
//                    arrayList[0].productId,
//                    arrayList[0].product_image,
//                    arrayList[0].product_name,
//                    arrayList[0].product_amount,
//                    arrayList[0].product_description,
//                    arrayList[0].product_category,
//                    arrayList[0].product_userid,
//                    arrayList[0].product_save, arrayList[0].cart_qty, arrayList[0].cart_total, 0
//                )
//                database.ProductDao().ucart(cartUpdate)
//            } else {
//                val cartUpdate = ProductEntity(
//                    arrayList[0].productId,
//                    arrayList[0].product_image,
//                    arrayList[0].product_name,
//                    arrayList[0].product_amount,
//                    arrayList[0].product_description,
//                    arrayList[0].product_category,
//                    arrayList[0].product_userid,
//                    arrayList[0].product_save, arrayList[0].cart_qty, arrayList[0].cart_total, 0
//                )
//                database.ProductDao().ucart(cartUpdate)
//            }
        }

//        val total = 0

        // binding.cartAmount.text = adapter.toString()

//        val productEntity = ProductEntity(0, null, "", "", "", "", 0, 0, 1, "")
//        cartViewModel = ViewModelProvider.of(this).get(CartViewModel::class.java)

//        var total = 0
//        cartViewModel.allProducts(productEntity).observe(this) {
//            it.let {
//                adapter.arrayList
//                total = 0
//                for (i in it.indices) {
//                    total += it[i].cart_total.toInt()
//                }
//                binding.cartAmount.text = total.toString()
//            }
//        }

        binding.backCart.setOnClickListener {
            val intent = Intent(this, Dashboard::class.java)
            startActivity(intent)
        }
    }
}