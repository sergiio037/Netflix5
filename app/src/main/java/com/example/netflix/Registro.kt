package com.example.netflix

import android.annotation.SuppressLint
import android.content.Intent
import android.content.res.ColorStateList
import android.graphics.Color
import android.net.Uri
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.netflix.databinding.ActivityRegistroBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase


class Registro : AppCompatActivity() {
    val user = User(this)
    lateinit var binding: ActivityRegistroBinding
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityRegistroBinding.inflate(layoutInflater)
        setContentView(binding.root)
        auth = Firebase.auth
        binding.registrarse.isEnabled=false
        binding.textAyuda.setOnClickListener(){
            var _uri = Uri.parse("https://help.netflix.com/es-es")
            startActivity(Intent(Intent.ACTION_VIEW,_uri))
        }

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
        binding.imageBack.setOnClickListener(){
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
            signup(binding.editTextTextGmailNumero.text.toString(),binding.editTextpass.text.toString())
        }
    }
    fun signup(email:String,password:String){
    auth.createUserWithEmailAndPassword(email, password)
    .addOnCompleteListener(this) { task ->
        if (task.isSuccessful) {
            // Sign in success, update UI with the signed-in user's information
            Toast.makeText(this, "Usuario Registrado", Toast.LENGTH_SHORT).show()
            val user = auth.currentUser
            updateUI(user)
        } else {
            // If sign in fails, display a message to the user.
            Toast.makeText(this, "Datos incorrectos", Toast.LENGTH_SHORT).show()
            Toast.makeText(baseContext, "Authentication failed.",
                Toast.LENGTH_SHORT).show()
            updateUI(null)
        }
    }}
    private fun updateUI(user: FirebaseUser?) {

    }

    private fun reload() {

    }
    @SuppressLint("UseCompatLoadingForDrawables")
    fun repetirPass(): Boolean{

        if (binding.editTextpass.text.toString().equals(binding.editTextRepitPass.text.toString()) && binding.editTextRepitPass.text.toString().isNotEmpty()){
            binding.editTextpass.background=getDrawable(R.drawable.logeo)
            binding.editTextRepitPass.background=getDrawable(R.drawable.logeo)
            binding.registrarse.backgroundTintList= ColorStateList.valueOf(Color.rgb(229,9,20))
            binding.registrarse.isEnabled=true
            return true
        }else if(binding.editTextRepitPass.text.toString().isEmpty()){
            binding.editTextpass.background=getDrawable(R.drawable.logeo)
            binding.editTextRepitPass.background=getDrawable(R.drawable.logeo)
            binding.registrarse.backgroundTintList= ColorStateList.valueOf(Color.rgb(20,20,20))
            binding.registrarse.isEnabled=false
            return false
        }else{
            binding.editTextpass.background=getDrawable(R.drawable.pass_fail)
            binding.editTextRepitPass.background=getDrawable(R.drawable.pass_fail)
            binding.registrarse.backgroundTintList= ColorStateList.valueOf(Color.rgb(20,20,20))
            binding.registrarse.isEnabled=false
            return false
        }


    }

}