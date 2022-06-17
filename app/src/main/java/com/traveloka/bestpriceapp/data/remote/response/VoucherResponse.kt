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

	@field:SerializedName("user_id")
	val userId: String,

	@field:SerializedName("product_id")
	val productId: String,

	@field:SerializedName("name")
	val name: String,

	@field:SerializedName("max_discount")
	val maxDiscount: Double,

	@field:SerializedName("id")
	val id: Int
)

