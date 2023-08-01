package com.example.android_practice_loginpage

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.widget.addTextChangedListener

class SignInActivity : AppCompatActivity() {
    private lateinit var resultLauncher: ActivityResultLauncher<Intent>
    private lateinit var loginEditText: EditText
    private lateinit var passwordEditText: EditText
    private lateinit var loginButton: Button

    var enableLoginButton = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)

        //회원 가입 페이지 이동 구현
        val signInButton = findViewById<Button>(R.id.bt_signin_signup)
        signInButton.setOnClickListener {
            val moveToSignupPage = Intent(this, SignUpActivity::class.java)
            startActivity(moveToSignupPage)
        }

        loginEditText = findViewById(R.id.et_signin_id)
        passwordEditText = findViewById(R.id.et_signin_password)
        loginButton = findViewById(R.id.bt_signin_login)

//        setResultNext()

        val loginTextWatcher = object : TextWatcher {
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

        loginEditText.addTextChangedListener(loginTextWatcher)
        passwordEditText.addTextChangedListener(loginTextWatcher)
        //로그인 시 홈 화면 이동 구현

        loginButton.setOnClickListener {
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
    }
//    private fun setResultNext() {
//        resultLauncher = registerForActivityResult(
//            ActivityResultContracts.StartActivityForResult()
//        ) { result ->
//            if (result.resultCode == RESULT_OK) {
//
//                val id = result.data?.getStringExtra("id") ?: ""
//                val password = result.data?.getStringExtra("password") ?: ""
//
//                loginEditText.setText(id)
//                passwordEditText.setText(password)
//
//            }
//        }
//    }
}