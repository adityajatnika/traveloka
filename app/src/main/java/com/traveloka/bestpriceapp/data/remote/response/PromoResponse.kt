package com.traveloka.bestpriceapp.data.remote.response

import com.google.gson.annotations.SerializedName

data class PromoResponse(

	@field:SerializedName("values")
	val values: List<PromoItem>,

	@field:SerializedName("message")
	val message: String
)

data class PromoCallResponse(

	@field:SerializedName("values")
	val values: String,

	@field:SerializedName("message")
	val message: String
)

