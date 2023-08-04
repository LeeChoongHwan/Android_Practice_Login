package com.example.android_practice_loginpage

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.core.widget.addTextChangedListener

class SignUpActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var signUpButton: Button
    private lateinit var nameEditText: EditText
    private lateinit var idEditText: EditText
    private lateinit var passwordEditText: EditText

    var enableButton = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        signUpButton = findViewById(R.id.bt_signup)
        nameEditText = findViewById(R.id.et_signup_name)
        idEditText = findViewById(R.id.et_signup_id)
        passwordEditText = findViewById(R.id.et_signup_password)

        nameEditText.addTextChangedListener(signUpTextWatcher)
        idEditText.addTextChangedListener(signUpTextWatcher)
        passwordEditText.addTextChangedListener(signUpTextWatcher)

        signUpButton.setOnClickListener(this)
    }

    private val signUpTextWatcher = object : TextWatcher {
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
    override fun onClick(v: View?) {
        when(v?.id) {
            R.id.bt_signup -> {
                if(enableButton) {
                    val resultIntent = Intent()
                    resultIntent.putExtra("signUpId", idEditText.text.toString())
                    resultIntent.putExtra("signUpPassword", passwordEditText.text.toString())
                    setResult(Activity.RESULT_OK, resultIntent)
                    finish()
                }
                else {
                    Toast.makeText(applicationContext, "내용을 확인해주세요", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}