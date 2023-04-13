package com.example.netflix

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

class Pantalla_carga : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pantalla_carga)
        Handler().postDelayed({

            this.navigateTo(Contenido::class.java,false)
        }, 4000)
    }
}
