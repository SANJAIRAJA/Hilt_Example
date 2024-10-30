package com.example.daggerimplementation.apiService

import com.example.daggerimplementation.model.Post
import retrofit2.http.GET

interface ApiService {

    @GET("posts")
    suspend fun getPosts(): List<Post>
}