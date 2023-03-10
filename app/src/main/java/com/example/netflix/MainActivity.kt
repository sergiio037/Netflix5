package com.example.netflix

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.netflix.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val inicar_sesion_intent = Intent(this,IniciarSesionActivity::class.java)
        binding.IniciarSesion.setOnClickListener(){
            startActivity(inicar_sesion_intent)
        }
        binding.textAyuda.setOnClickListener(){
            var _uri = Uri.parse("https://help.netflix.com/es-es")
            startActivity(Intent(Intent.ACTION_VIEW,_uri))
        }
    }
}