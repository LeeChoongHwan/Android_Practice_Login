package com.example.android_practice_loginpage

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import kotlin.random.Random

class HomeActivity : AppCompatActivity() {

    var images = listOf<Int>(R.drawable.profile1, R.drawable.profile2, R.drawable.profile3, R.drawable.profile4, R.drawable.profile5)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val textId = findViewById<TextView>(R.id.tv_home_id)
        val idData = intent.getStringExtra("loginId")
        val finishButton = findViewById<Button>(R.id.bt_home_exit)
        val image = findViewById<ImageView>(R.id.iv_home_image)

        val randomNum = (0..4).random()
        image.setImageResource(images[randomNum])

        textId.text = "아이디 : $idData"

        finishButton.setOnClickListener {
            finish()
        }
    }
}