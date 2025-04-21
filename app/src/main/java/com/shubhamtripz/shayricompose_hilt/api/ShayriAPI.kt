package com.shubhamtripz.shayricompose_hilt.api

import com.shubhamtripz.shayricompose_hilt.models.ShayriItem
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers

interface ShayriAPI {

    @GET("v3/b/680673458a456b79668e43cd?meta=false")
   suspend fun getShayris(@Header("X-JSON-PATH")category: String) : Response<List<ShayriItem>>

   @GET("v3/b/680673458a456b79668e43cd?meta=false")
   @Headers("X-JSON-PATH: shayri..category")
   suspend fun getCategories() : Response<List<String>>
}