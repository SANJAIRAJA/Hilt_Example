package com.example.daggerimplementation.repository

import com.example.daggerimplementation.apiService.ApiService
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UserRepository @Inject constructor(private var apiService: ApiService) {
    suspend fun userData() = apiService.getPosts()
}