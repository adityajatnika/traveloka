package com.traveloka.bestpriceapp.data.remote.response

import com.google.gson.annotations.SerializedName

data class CampaignActiveResponse(

	@field:SerializedName("values")
	val values: String,

	@field:SerializedName("message")
	val message: String
)
