package com.ejemlo.tp_mercadolibre.io

import com.ejemlo.tp_mercadolibre.Products
import com.ejemlo.tp_mercadolibre.model.Item
import com.ejemlo.tp_mercadolibre.model.SearchResult
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class API {
    private val service : mercadolibreinter = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl("https://api.mercadolibre.com/")
        .build()
        .create(mercadolibreinter::class.java)

    fun search (q :String) : Call<SearchResult> {
        return service.search(q)
    }

    fun getItem(id : String) : Call<Item> {
        return service.getItem(id)
    }

}