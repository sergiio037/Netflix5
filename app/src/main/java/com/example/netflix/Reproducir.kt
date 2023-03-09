package com.example.netflix

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.netflix.databinding.ActivityMainBinding
import com.example.netflix.databinding.ActivityReproducirBinding

class Reproducir : AppCompatActivity() {
    lateinit var binding: ActivityReproducirBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityReproducirBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}