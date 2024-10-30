package com.example.daggerimplementation.ui.activity

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.daggerimplementation.ui.viewModel.PostViewModel
import com.example.daggerimplementation.databinding.ActivityMainBinding
import com.example.daggerimplementation.ui.viewModel.UserViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModel: PostViewModel by viewModels()
    private val viewModelUser : UserViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setUpObserver()

        viewModel.posts.observe(this) { posts ->
            // Update the RecyclerView with the posts
            // For simplicity, just log the data
            Log.d("MainActivity", "Posts: ${posts[0].title}")
        }

        viewModelUser.posts.observe(this) { posts ->
            // Update the RecyclerView with the posts
            // For simplicity, just log the data
            Log.d("MainActivity", "Posts: ${posts[0].title}")
        }


        binding.tvText.setOnClickListener {
        }
    }

    private fun setUpObserver() {

    }

    companion object{
        val TAG = "MainActivity"
    }
}