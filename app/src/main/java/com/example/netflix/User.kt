package com.example.netflix

import android.content.Context

class User(private val context: Context) {

    var username: String = ""
    var password: String = ""
    var sexo: Char = 'H'
    var nacionalidad: String = ""
    var aficiones: ArrayList<String> = ArrayList()
    var curriculum: String = ""

    fun save() {
        val editor = context.getSharedPreferences("user:${this.username.lowercase()}", Context.MODE_PRIVATE).edit()
        editor.putString("username", username)
        editor.putString("password", password)
        editor.putString("sexo", sexo.toString())
        editor.putString("nacionalidad", nacionalidad)
        editor.putString("aficiones", aficiones.joinToString(","))
        editor.putString("curriculum", curriculum)
        editor.apply()
    }

    fun login() {
        val prefs = context.getSharedPreferences("logged", Context.MODE_PRIVATE)
        val editor = prefs.edit()
        editor.putString("username", username)
        editor.apply()
    }

    companion object {
        fun load(context: Context, username: String): User? {
            val user = User(context)
            val prefs = context.getSharedPreferences("user:${username.lowercase()}", Context.MODE_PRIVATE)
            if (prefs.getString("username", "") == "") return null
            user.username = prefs.getString("username", "") ?: ""
            user.password = prefs.getString("password", "") ?: ""
            user.sexo = prefs.getString("sexo", "H")?.get(0) ?: 'H'
            user.nacionalidad = prefs.getString("nacionalidad", "") ?: ""
            user.aficiones = prefs.getString("aficiones", "")?.split(",")?.toCollection(ArrayList()) ?: ArrayList()
            user.curriculum = prefs.getString("curriculum", "") ?: ""
            return user
        }

        fun getLogged(context: Context): User? {
            val prefs = context.getSharedPreferences("logged", Context.MODE_PRIVATE)
            val username = prefs.getString("username", "") ?: ""
            return if (username.isNotEmpty()) load(context, username) else null
        }

        fun canLogin(context: Context, username: String, password: String): Boolean {
            val prefs = context.getSharedPreferences("user:${username.lowercase()}", Context.MODE_PRIVATE)
            return prefs.getString("username", "") == username && prefs.getString("password", "") == password
        }

        fun logout(context: Context) {
            context.getSharedPreferences("logged", Context.MODE_PRIVATE).edit().clear().apply()
        }
    }
}