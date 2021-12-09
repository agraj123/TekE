package com.example.teke.Product

import androidx.lifecycle.LiveData
import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface ProductDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertProduct(productEntity: ProductEntity?)

    @Insert
    fun insertList(productEntity: List<ProductEntity>)

    @Query("UPDATE product SET product_save = :save WHERE product_name=:name")
    fun updateProduct(save: Boolean, name: String)

    @Query("SELECT * FROM product where product_userid= :userId ORDER BY product_name")
    fun fetchProductList(userId: Int): List<ProductEntity>

    @Query("SELECT * FROM product where product_save= :save and product_userid= :userId ORDER BY product_name")
    fun fetchWishList(save: String, userId: Int): List<ProductEntity>

    @Query("SELECT product_save FROM product where productId= :productId and product_userid= :userId")
    fun getProductSave(productId: Int?, userId: Int): Int

    @Query("select product_name from product")
    fun getProductData(): List<String>

    @Query("SELECT product_name FROM product")
    fun getAllProduct(): List<String>

    @Query("SELECT * FROM product")
    fun all(): List<ProductEntity>

    @Query("SELECT product_save FROM product WHERE productId=:Id")
    fun getFavId(Id: Int): Int

    @Query("SELECT * FROM product WHERE product_name=:Name")
    fun getName(Name: String): List<ProductEntity>

    @Query("UPDATE product SET cart_qty = :save WHERE product_name= :name")
    fun updateCart(save: Boolean, name: String)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertCart(cartEntity: ProductEntity?)

    @Query("SELECT * FROM product where product_userid= :userId ORDER BY product_name")
    fun fetchCartList(userId: Int): List<ProductEntity>

    @Query("SELECT * FROM product WHERE cart_qty=:Name")
    fun setFavData(Name: Int?): List<ProductEntity>

    @Query("SELECT * FROM product WHERE cart_qty>= 1")
    fun fetchSave(): List<ProductEntity>

    @Query("SELECT * FROM product WHERE product_save=:Name")
    fun setWishData(Name: Int?): List<ProductEntity>

    @Query("SELECT * FROM product WHERE product_save=1")
    fun fetchWish(): List<ProductEntity>

    @Delete
    fun deleteCart(cartEntity: ProductEntity?)

    @Query("DELETE FROM product WHERE product_name=:Name")
    fun delete(Name: String?): Int

    @Update
    fun ucart(productEntity: ProductEntity?)
}