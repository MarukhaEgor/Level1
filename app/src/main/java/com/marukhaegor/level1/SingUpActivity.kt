package com.marukhaegor.level1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.view.View
import android.widget.Button
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class SingUpActivity : AppCompatActivity() {
    lateinit var name: String
    lateinit var secondName: String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.signup_activity)
        val btn = findViewById<Button>(R.id.signUpViewRegBtn)
        btn.setOnClickListener{
            onClick()
        }
    }

    private fun validChecker(): Boolean{
        return isValidMail() && isValidPass()
    }

    private fun isValidMail(): Boolean{
        val emailEditText = findViewById<View>(R.id.signUpViewTemailEt) as TextInputEditText
        val email = emailEditText.text
        val emailLayout = findViewById<View>(R.id.signUpViewEmailTIL) as TextInputLayout
        if (email?.isNotEmpty() == true && Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            email.substring(0, email.indexOf(".")).also { name = it }
            email.substring(email.indexOf(".") + 1, email.indexOf("@")).also { secondName = it }
            return true
        }
        emailLayout.error = getString(R.string.wrong_mail_msg)
        return false
    }

    private fun isValidPass(): Boolean{
        val passEditText = findViewById<View>(R.id.signUpViewPassEt) as TextInputEditText
        val pass = passEditText.text
        val passLayout = findViewById<View>(R.id.signUpViewPassTIL) as TextInputLayout
        if (pass?.isNotEmpty() == true && pass.length > 8){
            return true
        }
        passLayout.error = getString(R.string.wrong_pass_msg)
        return false
    }

    private fun onClick() {
        val intent = Intent(this, ProfileActivity::class.java)
        if (validChecker()) {
            intent.putExtra("name",name)
            intent.putExtra("secondName",secondName)
            startActivity(intent)
        }
    }
}