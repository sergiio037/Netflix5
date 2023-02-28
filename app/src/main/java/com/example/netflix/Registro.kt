package com.example.netflix

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.AdapterView
import android.widget.Toast
import com.example.netflix.databinding.ActivityRegistroBinding

class Registro : AppCompatActivity() {
    val user = User(this)
    lateinit var binding: ActivityRegistroBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegistroBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.editTextTextGmailNumero.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {}
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                user.username = s.toString()
                repetirPass()
            }
        })
        binding.editTextRepitPass.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {}
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

                repetirPass()
            }
        })

        binding.editTextpass .addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {}
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

                user.password = s.toString()
                repetirPass()
            }
        })
        val iniciar_intent = Intent(this,IniciarSesionActivity::class.java)
        binding.IniciarSesion.setOnClickListener(){
                startActivity(iniciar_intent)
        }


        binding.registrarse.setOnClickListener {
            if (!repetirPass()) {
                Toast.makeText(this, "Datos incorrectos", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            if (User.load(this, user.username) != null) {
                Toast.makeText(this, "El usuario ya existe", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            user.save()
            startActivity(iniciar_intent)

        }
    }
    @SuppressLint("UseCompatLoadingForDrawables")
    fun repetirPass(): Boolean{

        if (binding.editTextpass.text.toString().equals(binding.editTextRepitPass.text.toString()) && binding.editTextRepitPass.text.toString().isNotEmpty()){
            binding.editTextpass.background=getDrawable(R.drawable.logeo)
            binding.editTextRepitPass.background=getDrawable(R.drawable.logeo)
            binding.registrarse.background=getDrawable(R.drawable.boton)
            binding.registrarse.isEnabled=true
            return true
        }else if(binding.editTextRepitPass.text.toString().isEmpty()){
            binding.editTextpass.background=getDrawable(R.drawable.logeo)
            binding.editTextRepitPass.background=getDrawable(R.drawable.logeo)
            binding.registrarse.background=getDrawable(R.drawable.boton_desactivado)
            binding.registrarse.isEnabled=false
            return false
        }else{
            binding.editTextpass.background=getDrawable(R.drawable.pass_fail)
            binding.editTextRepitPass.background=getDrawable(R.drawable.pass_fail)
            binding.registrarse.background=getDrawable(R.drawable.boton_desactivado)
            binding.registrarse.isEnabled=false
            return false
        }

    }

}