package com.marukhaegor.level1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val intent = intent
        val name = intent.getStringExtra("name") + " " + intent.getStringExtra("secondName")
        val profileEditText = findViewById<View>(R.id.profile_activ_name_editTxt) as TextView
        profileEditText.text = name
    }
}