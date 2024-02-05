package com.nanto.lail.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.aldi.matsurat.data.response.ResponseLogin
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth
import com.nanto.lail.data.local.UserPreferences
import com.r10.lail.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val mb = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mb.root)

        auth = Firebase.auth

        mb.cardPagi.setOnClickListener {
            val  intent = Intent(this, MorningActivity::class.java)
            intent.putExtra(MorningActivity.MODE, "morning")
            startActivity(intent)
        }

        mb.cardPetang.setOnClickListener {
            val  intent = Intent(this, MorningActivity::class.java)
            intent.putExtra(MorningActivity.MODE, "evening")
            startActivity(intent)
        }

        mb.btnLogout.setOnClickListener {
            val database = UserPreferences(this)
            val user = ResponseLogin()
            user.username = null
            user.password = null
            database.setUser(user)


            // menambahkan sign out
            auth.signOut()

            startActivity(Intent(this, LoginActivity::class.java))
            finish()
        }

        mb.tvUsername.text = UserPreferences(this).getUser().username
    }
}

