package com.codingub.hackathonproject.data.local

import android.content.Context
import android.content.SharedPreferences
import com.codingub.hackathonproject.MainApp

object UserConfig {

    private val key_user_token = "token"
    private val key_user_type = "user_type"

    private val key_user_username = "user_username"
    private val key_user_password = "user_password"
    private val key_user_phonenumber = "user_phonenumber"

    private val prefs: SharedPreferences =
        MainApp.getInstance().getSharedPreferences(
            "${MainApp.getInstance().packageName}_${this::class.java.simpleName}",
            Context.MODE_PRIVATE
        )
    private val editor: SharedPreferences.Editor get() = prefs.edit()

    // аутентификация
    private var token: String = ""

    fun getToken(): String = prefs.getString(key_user_token, "") ?: ""
    fun setToken(value: String) {
        token = value
        editor.putString(key_user_token, token).commit()
    }

    private var username : String = ""

    fun getUsername(): String = prefs.getString(key_user_username, "") ?: ""
    fun setUsername(value: String) {
        username = value
        editor.putString(key_user_username, username).commit()
    }

    private var password : String = ""

    fun getPassword(): String = prefs.getString(key_user_password, "") ?: ""
    fun setPassword(value: String) {
        password = value
        editor.putString(key_user_password, password).commit()
    }

    private var phoneNumber : String = ""

    fun getPhoneNumber(): String = prefs.getString(key_user_phonenumber, "") ?: ""
    fun setPhoneNumber(value: String) {
        phoneNumber = value
        editor.putString(key_user_password, phoneNumber).commit()
    }
}