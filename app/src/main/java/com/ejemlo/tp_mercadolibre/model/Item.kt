package com.ejemlo.tp_mercadolibre.model

import com.google.gson.annotations.SerializedName

data class Item (
    @SerializedName("id") val id : String,
//    @SerializedName("site_id") val site_id : String,
    @SerializedName("title") val title : String,
//    @SerializedName("subtitle") val subtitle : String,
//    @SerializedName("seller_id") val seller_id: Int,
//    @SerializedName("category_id") val category_id : String,
//    @SerializedName("official_store_id") val official_store_id : String,
    @SerializedName("price") val price : String,
//    @SerializedName("base_price") val base_price : Int,
//    @SerializedName("original_price") val original_price : String,
//    @SerializedName("currency_id") val currency_id : String,
//    @SerializedName("initial_quantity") val initial_quantity : Int,
    @SerializedName("available_quantity") val available_quantity : String,
//    @SerializedName("sold_quantity") val sold_quantity : Int,
//    @SerializedName("sale_terms") val sale_terms : List<SaleTerms>,
//    @SerializedName("buying_mode") val buying_mode : String,
//    @SerializedName("listing_type_id") val listing_type_id : String,
//    @SerializedName("start_time") val start_time : String,
//    @SerializedName("stop_time") val stop_time : String,
    @SerializedName("condition") val condition : String,
//    @SerializedName("permalink") val permalink : String,
    @SerializedName("thumbnail") val thumbnail : String
//    @SerializedName("secure_thumbnail") val secure_thumbnail : String,
//    @SerializedName("pictures") val pictures : List<Pictures>,
//    @SerializedName("video_id") val video_id : String,
//    @SerializedName("descriptions") val descriptions : List<Descriptions>,
//    @SerializedName("accepts_mercadopago") val accepts_mercadopago : Boolean,
//    @SerializedName("non_mercado_pago_payment_methods") val non_mercado_pago_payment_methods : List<String>,
//    @SerializedName("international_delivery_mode") val international_delivery_mode : String,
//    @SerializedName("geolocation") val geolocation : Geolocation,
//    @SerializedName("coverage_areas") val coverage_areas : List<String>,
//    @SerializedName("attributes") val attributes : List<Attributes>,
//    @SerializedName("warnings") val warnings : List<String>,
//    @SerializedName("listing_source") val listing_source : String,
//    @SerializedName("variations") val variations : List<String>,
//    @SerializedName("status") val status : String,
//    @SerializedName("sub_status") val sub_status : List<String>,
//    @SerializedName("tags") val tags : List<String>,
//    @SerializedName("warranty") val warranty : String,
//    @SerializedName("catalog_product_id") val catalog_product_id : String,
//    @SerializedName("domain_id") val domain_id : String,
//    @SerializedName("parent_item_id") val parent_item_id : String,
//    @SerializedName("differential_pricing") val differential_pricing : String,
//    @SerializedName("deal_ids") val deal_ids : List<String>,
//    @SerializedName("automatic_relist") val automaticRealist : Boolean,
//    @SerializedName("date_created") val date_created : String,
//    @SerializedName("last_updated") val last_updated : String,
//    @SerializedName("health") val health : String,
//    @SerializedName("catalog_listing") val catalog_listing : Boolean
)


data class Geolocation(
    val id: String
)

data class Attributes (
    val id :String
)

data class Descriptions (
    val id :String
)

data class Pictures (

    @SerializedName("id") val id : String,
    @SerializedName("url") val url : String,
    @SerializedName("secure_url") val secure_url : String,
    @SerializedName("size") val size : String,
    @SerializedName("max_size") val max_size : String,
    @SerializedName("quality") val quality : String
)

data class SaleTerms (
    val id :String
)
