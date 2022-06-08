package com.traveloka.bestpriceapp.data.remote.response

import com.google.gson.annotations.SerializedName

data class CampaignResponse<CampaignItem>(

	@field:SerializedName("values")
	val values: List<CampaignItem>,

	@field:SerializedName("message")
	val message: String
)

data class CampaignCallResponse(

	@field:SerializedName("values")
	val values: List<CampaignItem>,

	@field:SerializedName("message")
	val message: String
)

data class CampaignItem(

	@field:SerializedName("end_date")
	val endDate: String,

	@field:SerializedName("promo")
	val promo: List<PromoItem>,

	@field:SerializedName("is_active")
	val isActive: Boolean,

	@field:SerializedName("updated_at")
	val updatedAt: String,

	@field:SerializedName("periodical")
	val periodical: Boolean,

	@field:SerializedName("every_weekend")
	val everyWeekend: Boolean,

	@field:SerializedName("name")
	val name: String,

	@field:SerializedName("created_at")
	val createdAt: String,

	@field:SerializedName("id")
	val id: Int,

	@field:SerializedName("start_date")
	val startDate: String
)

data class PromoItem(

	@field:SerializedName("category_name")
	val categoryName: String,

	@field:SerializedName("updated_at")
	val updatedAt: String,

	@field:SerializedName("name")
	val name: String,

	@field:SerializedName("created_at")
	val createdAt: String,

	@field:SerializedName("discount")
	val discount: Double,

	@field:SerializedName("max_discount")
	val maxDiscount: Double,

	@field:SerializedName("id")
	val id: Int,

	@field:SerializedName("campaign_id")
	val campaignId: Int
)
