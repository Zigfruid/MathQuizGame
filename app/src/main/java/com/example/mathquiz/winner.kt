package com.example.mathquiz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.AnimationUtils
import kotlinx.android.synthetic.main.activity_loser.*
import kotlinx.android.synthetic.main.activity_winner.*
import kotlinx.android.synthetic.main.activity_winner.IvParashutte

class winner : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_winner)
        tvScoreWinner.text = intent.getStringExtra("sendF")
        val topToBottom = AnimationUtils.loadAnimation(this, R.anim.fromtop)
        val bottomToTop = AnimationUtils.loadAnimation(this , R.anim.frombottom)
        val rightToLeft = AnimationUtils.loadAnimation(this,R.anim.righttoleft)
        val leftToRight = AnimationUtils.loadAnimation(this, R.anim.lefttoright)
        btnExit2.startAnimation(leftToRight)
        IvParashutte.startAnimation(topToBottom)
        tvWinner.startAnimation(bottomToTop)
        tvScoreWinner.startAnimation(rightToLeft)

        btnExit2.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            startActivity(intent)
            finish()
        }
    }
}
