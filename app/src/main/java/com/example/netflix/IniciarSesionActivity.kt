package com.example.netflix


import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.netflix.databinding.ActivityIniciarSesionBinding


class IniciarSesionActivity : AppCompatActivity() {
    lateinit var binding: ActivityIniciarSesionBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityIniciarSesionBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.imageBack.setOnClickListener(){
            this.navigateTo(MainActivity::class.java)
        }
        binding.registrarse.setOnClickListener {
            this.navigateTo(Registro::class.java)
        }

        binding.IniciarSesion.setOnClickListener {

            if (User.canLogin(
                    this,
                    binding.editTextTextInicioSesion.text.toString(),
                    binding.editTextpass.text.toString()
                )
            ) {
                val user = User.load(this, binding.editTextTextInicioSesion.text.toString())
                if (user == null) {
                    Toast.makeText(this, "Invalid credentials", Toast.LENGTH_SHORT).show()
                    return@setOnClickListener
                }

                user.login()
                this.navigateTo(Pantalla_carga::class.java, true)
            } else
                Toast.makeText(this, "Invalid credentials", Toast.LENGTH_SHORT).show()
        }

        val listener = object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {}
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                comprobar()
            }
        }

        binding.editTextTextInicioSesion.addTextChangedListener(listener)
        binding.editTextpass.addTextChangedListener(listener)
    }
    @SuppressLint("UseCompatLoadingForDrawables")
    fun comprobar(){
        if(binding.editTextTextInicioSesion.length()>3 && binding.editTextpass.length()>3) {
            binding.IniciarSesion.background = getDrawable(R.drawable.boton)
            binding.IniciarSesion.isEnabled=true
        } else{
            binding.IniciarSesion.background = getDrawable(R.drawable.boton_desactivado)
            binding.IniciarSesion.isEnabled=false
        }

    }
    }


    fun Activity.navigateTo(dst: Class<*>, withReset: Boolean = false) {
        val intent = Intent(this, dst)
        if (withReset) intent.flags =
            Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        startActivity(intent)
    }