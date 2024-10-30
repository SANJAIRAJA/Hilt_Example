package com.example.daggerimplementation.repository

import com.example.daggerimplementation.apiService.ApiService
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PostRepository @Inject constructor(private val apiService: ApiService) {
    suspend fun getPosts() = apiService.getPosts()
}