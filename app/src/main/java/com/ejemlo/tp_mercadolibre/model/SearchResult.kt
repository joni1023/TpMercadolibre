package com.ejemlo.tp_mercadolibre.model

import android.location.Address
import com.google.gson.annotations.SerializedName

data class SearchResult (
//    @SerializedName("site_id") val siteId : String,
//    @SerializedName("query") val query : String,
   @SerializedName("paging") val paging : Paging,
    @SerializedName("results") val results : List<Productos>
//    @SerializedName("secondary_results") val secondary_results : List<String>,
//    @SerializedName("related_results") val related_results : List<String>,
//    @SerializedName("sort") val sort : Sort,
//    @SerializedName("available_sorts") val available_sorts : List<String>,
//    @SerializedName("filters") val filters : List<String>,
//    @SerializedName("available_filters") val available_filters : List<String>


)
data class Paging(
    @SerializedName("total") val total : String
)


data class Productos (
    @SerializedName("id") val id : String,
//    @SerializedName("site_id") val site_id : String,
    @SerializedName("title") val title : String,
    @SerializedName("price") val price : String,
//    @SerializedName("currency_id") val currency_id : String,
//    @SerializedName("available_quantity") val available_quantity : Int,
//    @SerializedName("sold_quantity") val sold_quantity : Int,
    @SerializedName("buying_mode") val buying_mode : String,
//    @SerializedName("listing_type_id") val listing_type_id : String,
//    @SerializedName("stop_time") val stop_time : String,
      @SerializedName("condition") val condition : String,
//    @SerializedName("permalink") val permalink : String,
      @SerializedName("thumbnail") val thumbnail : String,
    @SerializedName("accepts_mercadopago") val accepts_mercado : Boolean,
//    @SerializedName("installments") val installments : String,
    @SerializedName("address") val address : com.ejemlo.tp_mercadolibre.model.Address
//    @SerializedName("attributes") val attributes : List<String>,
//    @SerializedName("original_price") val original_price : String,
//    @SerializedName("category_id") val category_id : String,
//    @SerializedName("official_store_id") val official_store_id : String,
//    @SerializedName("domain_id") val domain_id : String,
//    @SerializedName("catalog_product_id") val catalog_product_id : String,
//    @SerializedName("tags") val tags : List<String>
)
data class Address(
    @SerializedName("state_name") val state_name : String,
    @SerializedName("city_name") val city_name : String
)



