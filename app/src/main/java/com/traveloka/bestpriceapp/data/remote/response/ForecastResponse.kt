package com.traveloka.bestpriceapp.data.remote.response

import com.google.gson.annotations.SerializedName

data class ForecastResponse(

	@field:SerializedName("values")
	val values: Values,

	@field:SerializedName("message")
	val message: String
)

data class Values(

	@field:SerializedName("auto")
	val auto: List<Int>
)
