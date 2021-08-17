package com.marukhaegor.level1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView

class ProfileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.profile_activity)
        val intent = intent
        setName(intent)
    }

    private fun setName(intent: Intent){
        val name = intent.getStringExtra("name") + " " + intent.getStringExtra("secondName")
        val profileEditText = findViewById<View>(R.id.profile_activ_name_tv) as TextView
        profileEditText.text = name
    }
}