package com.nanto.lail.data.local

import android.content.Context
import com.aldi.matsurat.data.response.ResponseLogin


class UserPreferences(context: Context) {
    companion object {
        private val PREF_NAME = "user_preferences"
        private val USERNAME = "username"
        private val PASSWORD = "password"

    }

    private val preferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)

    // fungsi untuk menyimpan data
    fun setUser(responseLogin: ResponseLogin){
        val set = preferences.edit()
        set.putString(USERNAME, responseLogin.username)
        set.putString(PASSWORD, responseLogin.password)

        set.apply()
    }


    // funsi untuk mengambil data
    fun getUser(): ResponseLogin{
        val data = ResponseLogin()
        data.username = preferences.getString(USERNAME, "muslim")
        data.password = preferences.getString(PASSWORD, "")

        return data
    }
}