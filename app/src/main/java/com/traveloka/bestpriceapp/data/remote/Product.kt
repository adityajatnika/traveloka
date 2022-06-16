package com.traveloka.bestpriceapp.data.remote

import android.os.Parcelable
import androidx.room.Entity
import kotlinx.parcelize.Parcelize
import java.util.*

@Parcelize
@Entity
data class Product(
    val name: String,
    val photo: String,
    val basePrice: String = "",
    val competitorPrice: Double? = 0.0,
    val discount: Float,
    val finalPrice: Double,
    val productCategory: String,
    val createdAt: Date,
    val updatedAt: Date,
) : Parcelable