package com.traveloka.bestpriceapp.data.remote.response

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

data class ProductResponse<ProductItem>(

	@field:SerializedName("values")
	val values: List<ProductItem>,

	@field:SerializedName("message")
	val message: String
)

data class ProductCallResponse(

	@field:SerializedName("values")
	val values: List<ProductItem>,

	@field:SerializedName("message")
	val message: String
)

@Parcelize
data class ProductItem(

	@field:SerializedName("updated_at")
	val updatedAt: String,

	@field:SerializedName("final_price")
	val finalPrice: Double,

	@field:SerializedName("base_price")
	val basePrice: Double,

	@field:SerializedName("name")
	val name: String,

	@field:SerializedName("created_at")
	val createdAt: String,

	@field:SerializedName("discount")
	val discount: Double,

	@field:SerializedName("id")
	val id: String,

	@field:SerializedName("competitor_price")
	val competitorPrice: Double,

	@field:SerializedName("product_category")
	val productCategory: String
) : Parcelable
