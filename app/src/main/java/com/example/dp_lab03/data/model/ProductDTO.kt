package com.example.kandroid_lab05.data.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity("products")
data class ProductDTO(@PrimaryKey val id:Int, var title:String ="", var description:String = "",
                      var thumbnail:String ="", var category:String = "", var rating: Double = 0.0,
                      var price:Double = 0.0) : Parcelable