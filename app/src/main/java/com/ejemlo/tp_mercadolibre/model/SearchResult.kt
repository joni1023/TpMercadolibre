package com.ejemlo.tp_mercadolibre.model

import com.google.gson.annotations.SerializedName

data class SearchResult (
   @SerializedName("paging") val paging : Paging,
    @SerializedName("results") val results : List<Productos>
)
data class Paging(
    @SerializedName("total") val total : String
)


data class Productos (
    @SerializedName("id") val id : String,
    @SerializedName("title") val title : String,
    @SerializedName("price") val price : String,
    @SerializedName("buying_mode") val buying_mode : String,
    @SerializedName("condition") val condition : String,
    @SerializedName("thumbnail") val thumbnail : String,
    @SerializedName("accepts_mercadopago") val accepts_mercado : Boolean,
    @SerializedName("address") val address : com.ejemlo.tp_mercadolibre.model.Address

)
data class Address(
    @SerializedName("state_name") val state_name : String,
    @SerializedName("city_name") val city_name : String
)



