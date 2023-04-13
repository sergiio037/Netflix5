package com.example.netflix


import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.content.res.ColorStateList
import android.graphics.Color
import android.net.Uri
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.netflix.databinding.ActivityIniciarSesionBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase


class IniciarSesionActivity : AppCompatActivity() {
    lateinit var binding: ActivityIniciarSesionBinding
    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityIniciarSesionBinding.inflate(layoutInflater)
        setContentView(binding.root)
        auth= Firebase.auth

        binding.imageBack.setOnClickListener(){
            this.navigateTo(MainActivity::class.java)
        }
        binding.registrarse.setOnClickListener {
            this.navigateTo(Registro::class.java)
        }
        binding.textAyuda.setOnClickListener(){
            var _uri = Uri.parse("https://help.netflix.com/es-es")
            startActivity(Intent(Intent.ACTION_VIEW,_uri))
        }

        binding.IniciarSesion.setOnClickListener {
                iniciarSesion(binding.editTextTextInicioSesion.text.toString(),binding.editTextpass.text.toString())
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
            binding.IniciarSesion.backgroundTintList= ColorStateList.valueOf(Color.rgb(229,9,20))
            binding.IniciarSesion.isEnabled=true
        } else{
            binding.IniciarSesion.backgroundTintList= ColorStateList.valueOf(Color.rgb(20,20,20))
            binding.IniciarSesion.isEnabled=false
        }

    }
    fun iniciarSesion(email:String,password:String){
    auth.signInWithEmailAndPassword(email, password)
    .addOnCompleteListener(this) { task ->
        if (task.isSuccessful) {
            // Sign in success, update UI with the signed-in user's information
            Toast.makeText(baseContext, "Correct",
                Toast.LENGTH_SHORT).show()
            val user = auth.currentUser
            updateUI(user)
        } else {
            // If sign in fails, display a message to the user.
            Toast.makeText(baseContext, "Authentication failed.",
                Toast.LENGTH_SHORT).show()
            updateUI(null)
        }
    }}
    private fun updateUI(user: FirebaseUser?) {

    }

    private fun reload() {

    }
    }


    fun Activity.navigateTo(dst: Class<*>, withReset: Boolean = false) {
        val intent = Intent(this, dst)
        if (withReset) intent.flags =
            Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        startActivity(intent)
    }