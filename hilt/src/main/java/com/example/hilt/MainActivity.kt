package com.example.hilt

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.example.hilt.databinding.ActivityMainBinding
import com.example.hilt.domain.MainVM
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private val viewModel: MainVM by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)


        viewModel.content.observe(this) { value ->
            binding.tvContent.text = value
        }

        binding.btn1.setOnClickListener {
            viewModel.fetchBaiduContent()
        }

    }
}