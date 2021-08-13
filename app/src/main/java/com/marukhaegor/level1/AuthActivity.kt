package com.marukhaegor.level1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.view.View
import android.widget.Button
import android.widget.EditText
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class AuthActivity : AppCompatActivity() {
    lateinit var name: String
    lateinit var secondName: String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.auth_activity)
        val btn = findViewById<Button>(R.id.signUp_reg_btn)
        btn.setOnClickListener{
            onClick(it)
        }
    }

    private fun validationMailCheck():Boolean{
        val emailEditText = findViewById<View>(R.id.email_edit_text) as TextInputEditText
        val email = emailEditText.text
        val emailLayout = findViewById<View>(R.id.email_text_input_layout) as TextInputLayout
        if (email!!.isNotEmpty() && Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            name = email.substring(0, email.indexOf("."))
            secondName = email.substring(email.indexOf(".") + 1, email.indexOf("@"))
            return true
        }
        emailLayout.error = "Wrong e-mail!!!"
        return false
    }

    private fun validatePass():Boolean{
        val passEditText = findViewById<View>(R.id.password_edit_text) as TextInputEditText
        val pass = passEditText.text
        val passLayout = findViewById<View>(R.id.pass_text_input_layout) as TextInputLayout
        if (pass!!.isNotEmpty() && pass.length > 8){
            return true
        }
        passLayout.error = "Short or empty pass!"
        return false
    }

    private fun onClick(view: View) {
        val intent = Intent(this, MainActivity::class.java)
        if (validationMailCheck() && validatePass()) {
            intent.putExtra("name",name)
            intent.putExtra("secondName",secondName)
            startActivity(intent)
        }
    }
}