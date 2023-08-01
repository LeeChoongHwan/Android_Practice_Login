package com.example.android_practice_loginpage

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val textId = findViewById<TextView>(R.id.tv_home_id)
        val idData = intent.getStringExtra("loginId")
        val finishButton = findViewById<Button>(R.id.bt_home_exit)

        textId.text = "아이디 : $idData"

        finishButton.setOnClickListener {
            finish()
        }
    }
}