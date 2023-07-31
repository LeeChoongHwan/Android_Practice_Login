package com.example.android_practice_loginpage

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.core.widget.addTextChangedListener

class SignUpActivity : AppCompatActivity() {

    var enableButton = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        val signUpButton = findViewById<Button>(R.id.bt_signup)
        val nameEditText = findViewById<EditText>(R.id.et_signup_name)
        val idEditText = findViewById<EditText>(R.id.et_signup_id)
        val passwordEditText = findViewById<EditText>(R.id.et_signup_password)

        val signUpTextWatcher = object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }
            override fun afterTextChanged(p0: Editable?) {
                val signUpNameInput = nameEditText.text.toString().trim()
                val signUpIdInput = idEditText.text.toString().trim()
                val passwordInput = passwordEditText.text.toString().trim()

                enableButton = signUpNameInput.isNotEmpty() && signUpIdInput.isNotEmpty() && passwordInput.isNotEmpty()
            }
        }

        nameEditText.addTextChangedListener(signUpTextWatcher)
        idEditText.addTextChangedListener(signUpTextWatcher)
        passwordEditText.addTextChangedListener(signUpTextWatcher)

        signUpButton.setOnClickListener {
            if(enableButton) {
                finish()
            }
            else {
                Toast.makeText(applicationContext, "내용을 확인해주세요", Toast.LENGTH_SHORT).show()
            }
        }
    }
}