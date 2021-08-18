package com.marukhaegor.level1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.view.View
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import com.marukhaegor.level1.databinding.SignupActivityBinding
import com.marukhaegor.level1.utils.Constants

class SingUpActivity : AppCompatActivity() {
    private lateinit var binding: SignupActivityBinding
    private lateinit var name: String
    private lateinit var secondName: String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = SignupActivityBinding.inflate(layoutInflater)
        setContentView(R.layout.signup_activity)
        setListeners()

    }

    private fun setListeners() {
        binding.signUpViewRegBtn.setOnClickListener {
            onClick()
        }
    }

    private fun validChecker(): Boolean{
        return isValidMail() && isValidPass()
    }

    private fun isValidMail(): Boolean{
        val email = binding.signUpViewEmailEt.text
        if (email?.isNotEmpty() == true && Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            email.substring(0, email.indexOf(".")).also { name = it }
            email.substring(email.indexOf(".") + 1, email.indexOf("@")).also { secondName = it }
            return true
        }
        binding.signUpViewEmailTIL.error = getString(R.string.wrong_mail_msg)
        return false
    }

    private fun isValidPass(): Boolean{
        val pass = binding.signUpViewPassEt.text
        if (pass?.isNotEmpty() == true && pass.length > Constants.PASS_MIN_LENGTH){
            return true
        }
        binding.signUpViewEmailTIL.error = getString(R.string.wrong_pass_msg)
        return false
    }

    private fun onClick() {
        val intent = Intent(this, ProfileActivity::class.java)
        if (validChecker()) {
            intent.putExtra(Constants.EXTRA_NAME,name)
            intent.putExtra(Constants.EXTRA_SECOND_NAME,secondName)
            startActivity(intent)
        }
    }
}