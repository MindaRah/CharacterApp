package com.minda.mycharactersapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.minda.mycharactersapp.api.CharacterApi
import com.minda.mycharactersapp.databinding.ActivityMainBinding
import com.minda.mycharactersapp.ui.viewmodel.CharacterViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}