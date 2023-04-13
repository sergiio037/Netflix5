package com.example.netflix

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.netflix.databinding.ActivityContenidoBinding

class Contenido : AppCompatActivity() {
    lateinit var binding: ActivityContenidoBinding
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding= ActivityContenidoBinding.inflate(layoutInflater)

        setContentView(binding.root)
        var reproducir =Intent(this,Reproducir::class.java)
        binding.btnPlayMovie.setOnClickListener(){
            startActivity(reproducir)
        }
        binding.linearLayoutPopularNarcos.setOnClickListener(){
            reproducir.putExtra("sp","Narcos")
            startActivity(reproducir)
        }
        binding.linearLayoutCasaDePapel.setOnClickListener(){
            reproducir.putExtra("sp","La casa de papel")
            startActivity(reproducir)
        }
        binding.linearLayoutPopularEntrevias.setOnClickListener(){
            reproducir.putExtra("sp","Entrevias")
            startActivity(reproducir)
        }
        binding.textAyuda.setOnClickListener(){
            var _uri = Uri.parse("https://help.netflix.com/es-es")
            startActivity(Intent(Intent.ACTION_VIEW,_uri))
        }


    }
}