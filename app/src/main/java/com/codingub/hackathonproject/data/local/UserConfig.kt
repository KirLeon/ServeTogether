package com.codingub.hackathonproject.data.local

import android.content.Context
import android.content.SharedPreferences
import androidx.lifecycle.MutableLiveData
import com.codingub.hackathonproject.MainApp
import com.codingub.hackathonproject.sdk.UserRole

object UserConfig {

    private val key_user_token = "token"
    private val key_user_type = "user_type"

    private val key_user_username = "user_username"
    private val key_user_phonenumber = "user_phonenumber"
    private val key_user_coins = "user_coins"

    private val prefs: SharedPreferences =
        MainApp.getInstance().getSharedPreferences(
            "${MainApp.getInstance().packageName}_${this::class.java.simpleName}",
            Context.MODE_PRIVATE
        )
    private val editor: SharedPreferences.Editor get() = prefs.edit()

    /*
        Token
     */
    private var token: String = ""

    fun getToken(): String = prefs.getString(key_user_token, "") ?: ""
    fun setToken(value: String) {
        token = value
        editor.putString(key_user_token, token).commit()
    }

    /*
        Username
     */
    private var username: String = ""

    fun getUsername(): String = prefs.getString(key_user_username, "") ?: ""
    fun setUsername(value: String) {
        username = value
        editor.putString(key_user_username, username).commit()
    }

    /*
        PhoneNumber
     */
    private var phoneNumber: String = ""

    fun getPhoneNumber(): String = prefs.getString(key_user_phonenumber, "") ?: ""
    fun setPhoneNumber(value: String) {
        phoneNumber = value
        editor.putString(key_user_phonenumber, phoneNumber).commit()
    }

    /*
        UserRole
     */
    private var savedUserRole: MutableLiveData<UserRole> =
        MutableLiveData(UserRole.valueOf(prefs.getString(key_user_type, UserRole.VOLUNTEER.name)!!))

    fun getUserRole(): UserRole = savedUserRole.value!!
    fun setUserRole(userRole: UserRole) {
        savedUserRole.value = userRole
        editor.putString(key_user_type, userRole.name).apply()
    }

    /*
        Coins
     */
    private var savedCoins: Long = 0L

    fun getCoins(): Long = prefs.getLong(key_user_coins, 0L)
    fun setCoins(value: Long) {
        savedCoins = value
        editor.putLong(key_user_coins, savedCoins)
    }
}