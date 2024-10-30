package com.example.daggerimplementation.ui.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.daggerimplementation.model.Post
import com.example.daggerimplementation.repository.PostRepository
import com.example.daggerimplementation.repository.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserViewModel @Inject constructor(private val repository: UserRepository,private val postRepository: PostRepository) :ViewModel(){
    private val _posts = MutableLiveData<List<Post>>()
    val posts: LiveData<List<Post>> = _posts

    private val _data = MutableStateFlow<List<Post>>(emptyList())
    val data: StateFlow<List<Post>> = _data


    init {
        fetchPosts()
    }

    private fun fetchPosts() {
        viewModelScope.launch {
            try {
                _posts.value = repository.userData()
            } catch (e: Exception) {
                Log.e("PostViewModel", "Error fetching posts", e)
            }
        }
    }

    private fun fetchData(){
        viewModelScope.launch {
            try {
                _data.value = postRepository.getPosts()
            }catch (e:Exception){
                Log.e("PostViewModel", "Error fetching posts", e)
            }
        }
    }
}