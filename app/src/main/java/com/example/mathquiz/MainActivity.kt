package com.example.mathquiz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.AnimationUtils
import android.widget.ImageView
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val fromLeftTo = AnimationUtils.loadAnimation(this, R.anim.lefttoright)
        val fromTopToBottom =AnimationUtils.loadAnimation(this, R.anim.fromtop)
        val bottomToTop = AnimationUtils.loadAnimation(this,R.anim.frombottom)
        val btnStart = findViewById<ImageView>(R.id.btnStart)
        val btnEnd = findViewById<ImageView>(R.id.btnEnd)
        tvWelcome.startAnimation(fromLeftTo)
        btnStart.startAnimation(bottomToTop)
        btnEnd.startAnimation(bottomToTop)
        IvParashutte.startAnimation(fromTopToBottom)
        btnStart.setOnClickListener {
           val nextPage = Intent(this, StartGameActivity::class.java)
            startActivity(nextPage)
            finish()
        }
        btnEnd.setOnClickListener {
            finish()
        }
    }
}
