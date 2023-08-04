package com.example.android_practice_loginpage

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
class HomeActivity : AppCompatActivity(), View.OnClickListener {

    private val images = listOf<Int>(R.drawable.profile1, R.drawable.profile2, R.drawable.profile3, R.drawable.profile4, R.drawable.profile5)
    private val randomNum = (0..4).random()

    private lateinit var textId : TextView
    private lateinit var finishButton: Button
    private lateinit var mainImage: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val idData = intent.getStringExtra("loginId")

        textId = findViewById(R.id.tv_home_id)
        finishButton = findViewById(R.id.bt_home_exit)
        mainImage = findViewById(R.id.iv_home_image)

        finishButton.setOnClickListener(this)

        setImage(mainImage, images)
        setText(textId, "아이디 : $idData")

    }
    override fun onClick(v: View?) {
        when(v?.id) {
            R.id.bt_home_exit -> {
                finish()
            }
        }
    }
    private fun setImage(image : ImageView, imageList : List<Int>) {
        image.setImageResource(imageList[randomNum])
    }
    private fun setText(textView:TextView, data:String) {
        textView.text = data
    }
}