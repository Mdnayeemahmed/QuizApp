package com.example.quizapp.controller

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.quizapp.R
import kotlinx.android.synthetic.main.activity_result.*

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.decorView.systemUiVisibility= View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN

        setContentView(R.layout.activity_result)

        val userName=intent.getStringExtra(SavedData.name)
        val score=intent.getStringExtra(SavedData.score)
        val total=intent.getStringExtra("Total Size")

        name.text="Congratulations ${userName}!!"
        result.text="${score} / ${total}"
        buttonfinish.setOnClickListener {
            startActivity(Intent(this,MainActivity::class.java))
        }
    }
}