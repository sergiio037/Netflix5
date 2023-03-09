package com.example.netflix

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.netflix.databinding.ActivityContenidoBinding
import com.example.netflix.databinding.ActivityReproducirBinding

class Contenido : AppCompatActivity() {
    lateinit var binding: ActivityContenidoBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityContenidoBinding.inflate(layoutInflater)

        setContentView(binding.root)
        binding.btnPlayMovie.setOnClickListener(){
            navigateTo(Reproducir::class.java)
        }


    }
}