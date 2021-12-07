package com.example.td6

import android.widget.EditText
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import retrofit2.converter.gson.GsonConverterFactory

import retrofit2.Retrofit






    interface GithubService {
        @GET("/users/{user}/repos")
        fun listRepos(@Path("user") user: String?): Call<List<Repo>>

        @GET("/search/repositories")
        fun searchRepos(@Query("q") query: String): Call<Repos>

        companion object {
            const val ENDPOINT = "https://api.github.com"
        }


    }

var service = Retrofit.Builder()
    .baseUrl(GithubService.ENDPOINT)
    .addConverterFactory(GsonConverterFactory.create())
    .build()
    .create(GithubService::class.java)