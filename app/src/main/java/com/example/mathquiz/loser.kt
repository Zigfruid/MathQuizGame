package com.example.mathquiz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.AnimationUtils
import kotlinx.android.synthetic.main.activity_loser.*

class loser : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_loser)
        tvScore.text = intent.getStringExtra("send")
        val topToBottom = AnimationUtils.loadAnimation(this,R.anim.fromtop)
        IvParashutte.startAnimation(topToBottom)
        val leftToR = AnimationUtils.loadAnimation(this, R.anim.lefttoright)
        val rightToL = AnimationUtils.loadAnimation(this,R.anim.righttoleft)
        val bottomToTop = AnimationUtils.loadAnimation(this , R.anim.frombottom)
        btnRetryEnd.startAnimation(bottomToTop)
        btnRetry.startAnimation(bottomToTop)
        tvLose.startAnimation(leftToR)
        tvScore.startAnimation(rightToL)
        btnRetry.setOnClickListener {
            intent = Intent(this, StartGameActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            startActivity(intent)
            finish()
        }
        btnRetryEnd.setOnClickListener {
            finish()
        }
    }

}
