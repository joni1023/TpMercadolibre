package com.ejemlo.tp_mercadolibre.io

import com.ejemlo.tp_mercadolibre.model.Item
import com.ejemlo.tp_mercadolibre.model.SearchResult
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface mercadolibreinter {
    @GET("sites/MLA/search")
    fun search(@Query("q") query: String?): Call<SearchResult>

    @GET("items/{itemId}")
    fun getItem(@Path("itemId") id: String): Call<Item>

}