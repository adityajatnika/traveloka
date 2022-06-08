package com.traveloka.bestpriceapp.data.remote.response

import com.google.gson.annotations.SerializedName

data class VoucherResponse<VoucherItem>(

	@field:SerializedName("values")
	val values: List<VoucherItem>,

	@field:SerializedName("message")
	val message: String
)

data class VoucherCallResponse(

	@field:SerializedName("values")
	val values: List<VoucherItem>,

	@field:SerializedName("message")
	val message: String
)

data class VoucherItem(

	@field:SerializedName("category_name")
	val categoryName: String,

	@field:SerializedName("updated_at")
	val updatedAt: String,

	@field:SerializedName("experied_date")
	val experiedDate: String,

	@field:SerializedName("name")
	val name: String,

	@field:SerializedName("created_at")
	val createdAt: String,

	@field:SerializedName("id")
	val id: Int,

	@field:SerializedName("discount_percent")
	val discountPercent: Double,

	@field:SerializedName("budget")
	val budget: Int
)
