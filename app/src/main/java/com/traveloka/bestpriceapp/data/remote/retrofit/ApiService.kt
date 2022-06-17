package com.traveloka.bestpriceapp.data.remote.retrofit

import com.traveloka.bestpriceapp.data.remote.response.*
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.http.*
import java.util.*

interface ApiService {

    // Customer Services
    @GET("users")
    fun getCustomers(): Call<CustomerResponse>

    // Product Services
    @GET("products")
    fun getProducts(
//        @Query("category") category: String? = null, // get by category
        @Query("page") page: Int? = 1, // get by page
    ): Call<ProductCallResponse>

    @GET("products{id}")
    fun getProduct(
        @Query("category") category: String?, // get by category
        @Query("page") page: Int?, // get by page
        @Path("id") id: String?, //get by id
    ): Call<ProductCallResponse>

//    @FormUrlEncoded
    @POST("products")
    fun addProduct(
        @Body requestBody: RequestBody,
//        @Field("name") name:String,
//        @Field("base_price") basePrice:Double,
//        @Field("product_category") productCategory:String
    ): Call<ProductCallResponse>

//    @Headers("Content-Type: application/json")
    @PUT("products/{id}")
    fun updateProduct(
        @Path("id") id : String,
        @Body requestBody: RequestBody,
//        @Field("base_price") basePrice:Double,
//        @Field("name") name: String,
    ): Call<ProductCallResponse>

    @FormUrlEncoded
    @DELETE("products/{id}")
    fun deleteProduct(
        @Path("id") id:String,
    ): Call<ProductCallResponse>


    // Campaign Services
    @GET("campaigns")
    fun getCampaigns(): Call<CampaignCallResponse>

    @FormUrlEncoded
    @POST("campaigns")
    fun addCampaign(
        @Field("name") name:String,
        @Field("start_date") startDate: Date,
        @Field("end_date") endDate: Date,
        @Field("periodical") periodical: Boolean,
        @Field("every_weekend") everyWeekend:Boolean
    ): Call<CampaignCallResponse>

    @FormUrlEncoded
    @PUT("campaigns/{id}")
    fun updateCampaign(
        @Path("id") id: Int,
        @Field("name") name:String,
        @Field("category_name") categoryName:String,
        @Field("start_date") startDate: Date,
        @Field("end_date") endDate: Date,
        @Field("periodical") periodical: Boolean,
        @Field("every_weekend") everyWeekend:Boolean,
        @Field("is_active") isActive:Boolean,
    ): Call<CampaignCallResponse>

    @FormUrlEncoded
    @PUT("campaigns/{id}/change_active")
    fun changeActiveCampaign(
        @Path("id") id: Int,
        @Field("is_active") isActive:Boolean,
        ): Call<CampaignCallResponse>

    @FormUrlEncoded
    @DELETE("campaigns/{id}")
    fun deleteCampaign(
        @Path("id") id: Int,
    ): Call<CampaignCallResponse>

    // Promo Services
    @GET("promos")
    fun getPromos(): PromoResponse<PromoItem>

    @FormUrlEncoded
    @POST("promos")
    fun addPromo(
        @Field("name") name:String,
        @Field("discount") discount: Float,
        @Field("category_name") categoryName: String,
        @Field("campaign_id") campaignId: Int,
        @Field("max_discount") maxDiscount: Double,
    ): Call<PromoCallResponse>

    @FormUrlEncoded
    @PUT("promos/{id}")
    fun updatePromo(
        @Path("id") id: Int,
        @Field("name") name:String,
        @Field("discount") discount: Float,
        @Field("category_name") categoryName: String,
        @Field("max_discount") maxDiscount: Double,
    ): Call<PromoCallResponse>

    @FormUrlEncoded
    @DELETE("promos/{id}")
    fun deletePromo(
        @Path("id") id: Int,
    ): Call<PromoCallResponse>

    // Voucher Services
    @GET("vouchers")
    fun getVouchers(): VoucherResponse<VoucherItem>

    @FormUrlEncoded
    @POST("vouchers")
    fun addVoucher(
        @Field("name") name:String,
        @Field("category_name") categoryName: String,
        @Field("discount_percent") discountPercent: Float,
        @Field("expired_date") expiredDate: Date,
        @Field("budget") budget:Double
    ): Call<VoucherCallResponse>

    @FormUrlEncoded
    @PUT("vouchers/{id}")
    fun updateVoucher(
        @Path("id") id: Int,
        @Field("name") name:String,
        @Field("category_name") categoryName: String,
        @Field("discount_percent") discountPercent: Float,
        @Field("expired_date") expiredDate: Date,
        @Field("budget") budget:Double
    ): Call<VoucherCallResponse>

    @FormUrlEncoded
    @DELETE("vouchers/{id}")
    fun deleteVoucher(
        @Path("id") id: Int,
    ): Call<VoucherCallResponse>
}