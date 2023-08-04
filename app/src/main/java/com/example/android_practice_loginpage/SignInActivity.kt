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
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.widget.addTextChangedListener

class SignInActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var loginEditText: EditText
    private lateinit var passwordEditText: EditText
    private lateinit var loginButton: Button
    private lateinit var signInButton : Button

    var enableLoginButton = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)

        loginEditText = findViewById(R.id.et_signin_id)
        passwordEditText = findViewById(R.id.et_signin_password)
        loginButton = findViewById(R.id.bt_signin_login)
        signInButton = findViewById(R.id.bt_signin_signup)

        loginEditText.addTextChangedListener(loginTextWatcher)
        passwordEditText.addTextChangedListener(loginTextWatcher)


        loginButton.setOnClickListener(this)
        signInButton.setOnClickListener(this)

    }

    private val loginTextWatcher = object : TextWatcher {
        override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
        }
        override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
        }
        override fun afterTextChanged(p0: Editable?) {
            val loginIdInput = loginEditText.text.toString().trim()
            val passwordInput = passwordEditText.text.toString().trim()
            enableLoginButton = loginIdInput.isNotEmpty() && passwordInput.isNotEmpty()
        }
    }

    private val signUpActivityResultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
        if (result.resultCode == Activity.RESULT_OK) {
            val data: Intent? = result.data
            val signUpId = data?.getStringExtra("signUpId")
            val signUpPassword = data?.getStringExtra("signUpPassword")

            loginEditText.setText(signUpId)
            passwordEditText.setText(signUpPassword)
        }
    }
    override fun onClick(v: View?) {
        when(v?.id) {
            R.id.bt_signin_login -> {
                if(enableLoginButton) {
                    val loginId = loginEditText.text.toString()
                    val moveToHomePage = Intent(this, HomeActivity::class.java)
                    moveToHomePage.putExtra("loginId", loginId)
                    startActivity(moveToHomePage)
                    Toast.makeText(applicationContext, "로그인에 성공했습니다.", Toast.LENGTH_SHORT).show()
                }
                else {
                    Toast.makeText(applicationContext, "아이디, 비밀번호를 확인해주세요.", Toast.LENGTH_SHORT).show()
                }
            }
            R.id.bt_signin_signup -> {
                val moveToSignupPage = Intent(this, SignUpActivity::class.java)
                signUpActivityResultLauncher.launch(moveToSignupPage)
            }
        }
    }

}