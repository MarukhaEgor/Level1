package com.marukhaegor.level1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import com.marukhaegor.level1.databinding.ProfileActivityBinding
import com.marukhaegor.level1.utils.Constants

class ProfileActivity : AppCompatActivity() {
    private lateinit var binding: ProfileActivityBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.profile_activity)
        binding = ProfileActivityBinding.inflate(layoutInflater)
        val intent = intent
        setName(intent)
    }

    private fun setName(intent: Intent){
        val name = intent.getStringExtra(Constants.EXTRA_NAME) + " " + intent.getStringExtra(Constants.EXTRA_SECOND_NAME)
        binding.profileActivityNameTv.text = name
    }
}