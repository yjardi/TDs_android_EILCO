package com.example.catalogue_cinema

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


interface service {
    @GET("/3/movie/popular?api_key=c1a1588b613cef60cc1c1934f75a5e24")
    fun searchfilmspopular(@Query("language") langue: String): Call<films>
    @GET("/3/genre/movie/list?api_key=c1a1588b613cef60cc1c1934f75a5e24")
    fun searchgenre(@Query("language") langue: String): Call<genres>
    @GET("/3/movie/upcoming?api_key=c1a1588b613cef60cc1c1934f75a5e24")
    fun searchfilmsupcoming(@Query("language") langue: String): Call<films>
    @GET("/3/search/movie?api_key=c1a1588b613cef60cc1c1934f75a5e24")
    fun searchfilms(@Query("query") query: String,@Query("language") langue: String): Call<films>
    companion object {
        const val ENDPOINT = "https://api.themoviedb.org";
    }

}
var servicef = Retrofit.Builder()
    .baseUrl(service.ENDPOINT)
    .addConverterFactory(GsonConverterFactory.create())
    .build()
    .create(service::class.java)