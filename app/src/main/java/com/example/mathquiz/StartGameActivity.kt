package com.example.mathquiz

import android.content.Intent
import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_start_game.*
import kotlin.random.Random



class StartGameActivity : AppCompatActivity() {
    var res = 0
    var count = 0
    private var isCanceled = false
    private val numberOfQuestion = 10




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start_game)
        game()
        count++
        tvCount.text = "Level : $count"
        tvMainScore.text = "Score : ${count-1}"
        timer.start()


    }

        private val timer = object : CountDownTimer(15000 , 1000){

        override fun onTick(p0: Long) {
           tvTimer.setText("Time : " + p0/1000 + " sec").toString()

        }

        override fun onFinish() {
           tvTimer.text = "Time is Over"
            val send = Intent(this@StartGameActivity, loser::class.java)
            send.putExtra("send", "Your Time is Over")
            send.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            startActivity(send)
        }


        }

    override fun onDestroy() {
        super.onDestroy()
        timer.cancel()
    }

    private fun game() {
        var a = Random.nextInt(50, 100)
        val b = Random.nextInt(5, 50)
        when (Random.nextInt(0, 4)) {
            1 ->{ tvMain.text = "$a+$b"
                res = a + b
            }

            2 -> {tvMain.text ="$a-$b"
            res = a-b
            }
            3 -> {tvMain.text ="$a*$b"
            res = a*b
            }
            else -> {
                res = Random.nextInt(50,200)
                a = res*b
                res = a/b
                tvMain.text = "$a/$b"
            }
        }

        val d = Random.nextInt(1, 4) + res
        val e = Random.nextInt(4, 6) + res
        val f = Random.nextInt(6, 8) + res
        val j = Random.nextInt(9, 10) + res

        val r = Random.nextInt(0, 4)
        val group = arrayListOf<Button>(btn1, btn3, btn3, btn4)
        btn1.text = "$d"
        btn2.text = "$e"
        btn3.text = "$f"
        btn4.text = "$j"
        group[r].text = "$res"
            for (i in 0..4) {
                if (i == r)
                    group[i].text = "$res"

            }

    }


    fun onclick(it: View) {
        if (count == numberOfQuestion) {
            val button = it as Button
            val pressedButton = button.text.toString().toInt()
            if (pressedButton == res) {
                Toast.makeText(this, "Верно", Toast.LENGTH_SHORT).show()
                tvCount.text = "Level : $count"
                tvMainScore.text = "Score : ${count-1}"
                val sendF = Intent(this, winner::class.java)
                sendF.putExtra("sendF", "Your Score : $count / 10")
                sendF.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
                startActivity(sendF)
                finish()
            } else {
                Toast.makeText(this, "Не Верно", Toast.LENGTH_SHORT).show()
                val send = Intent(this, loser::class.java)
                send.putExtra("send", "Your Score : ${count - 1} / 10")
                send.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
                startActivity(send)
                finish()
            }
        }else{
            when (count) {
                in 4..6 -> {
                    val button = it as Button
                    val pressedButton = button.text.toString().toInt()
                    if (pressedButton == res) {
                        Toast.makeText(this, "Верно", Toast.LENGTH_SHORT).show()
                        count++
                        tvCount.text = "Level : $count"
                        tvMainScore.text = "Score : ${count-1}"
                    } else {
                        Toast.makeText(this, "Не Верно", Toast.LENGTH_SHORT).show()
                        val send = Intent(this, loser::class.java)
                        send.putExtra("send", "Your Score : ${count - 1} / 10")
                        send.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
                        startActivity(send)
                        finish()
                    }
                    levelNormal()
                    timer.start()
                }
                in 6..10 -> {
                    val button = it as Button
                    val pressedButton = button.text.toString().toInt()
                    if (pressedButton == res) {
                        Toast.makeText(this, "Верно", Toast.LENGTH_SHORT).show()
                        count++
                        tvCount.text = "Level : $count"
                        tvMainScore.text = "Score : ${count-1}"
                    } else {
                        Toast.makeText(this, "Не Верно", Toast.LENGTH_SHORT).show()
                        val send = Intent(this, loser::class.java)
                        send.putExtra("send", "Your Score : ${count - 1} / 10")
                        send.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
                        startActivity(send)
                        finish()
                    }
                    levelHard()
                    timer.start()
                }
                else -> {
                    val button = it as Button
                    val pressedButton = button.text.toString().toInt()
                    if (pressedButton == res) {
                        Toast.makeText(this, "Верно", Toast.LENGTH_SHORT).show()
                        count++
                        tvCount.text = "Level : $count"
                        tvMainScore.text = "Score : ${count-1}"
                    } else {
                        Toast.makeText(this, "Не Верно", Toast.LENGTH_SHORT).show()
                        val send = Intent(this, loser::class.java)
                        send.putExtra("send", "Your Score : ${count - 1} / 10")
                        startActivity(send)
                        finish()
                    }

                    game()
                    timer.start()
                }
            }
        }
    }
    private fun levelNormal(){
        var a = Random.nextInt(150, 200)
        val b = Random.nextInt(10, 30)
        val g = Random.nextInt(15,150)
        when (Random.nextInt(0, 4)) {
            1 ->{tvMain.text = "$a+$b*$g"
            res = a+b*g
            }
            2 ->{tvMain.text = "$a*$b*$g"
            res = a*b*g
            }
            3 ->{tvMain.text = "$a*$b-$g"
            res = a*b-g
            }
            else ->{

                res = Random.nextInt(50,200)
                a = res*b
                res = a/b
                tvMain.text = "$a/$b+$g"

                res = a/b+g
                }
        }


        val r = Random.nextInt(0, 4)
        val group = arrayListOf<Button>(btn1, btn3, btn3, btn4)

        val d = Random.nextInt(1, 4) + res
        val e = Random.nextInt(4, 6) + res
        val f = Random.nextInt(7, 9) + res
        val j = Random.nextInt(10, 12) + res

        btn1.text = "$d"
        btn2.text = "$e"
        btn3.text = "$f"
        btn4.text = "$j"
        group[r].text = "$res"
        for (i in 0..4) {
            if (i == r)
                group[i].text = "$res"
        }


    }
    private fun levelHard(){
        val a = Random.nextInt(50, 100)
        val b = Random.nextInt(5, 50)
        val g = Random.nextInt(20,100)
        val h = Random.nextInt(2,10)
        val c = Random.nextInt(0, 4)
        tvMain.text = when (c) {
            1 -> "($a+$b)+($g*$g)/$h"
            2 -> "($a*$b)/$h-($g*$h)"
            3 -> "(($a*$b)*($g*$g))/$h"
            else -> "($a*$b)/($g*$h)"
        }
        res = when (c) {
            1 -> (a+b)+(g*g)/h
            2 -> (a*b)/h-(g*h)
            3 -> ((a*b)*(g*g))/h
            else -> (a*b)/(g*h)
        }
        val d = Random.nextInt(1, 4) + res
        val e = Random.nextInt(5, 7) + res
        val f = Random.nextInt(8, 10) + res
        val j = Random.nextInt(11, 13) + res

        val r = Random.nextInt(0, 4)
        val group = arrayListOf<Button>(btn1, btn3, btn3, btn4)
        btn1.text = "$d"
        btn2.text = "$e"
        btn3.text = "$f"
        btn4.text = "$j"
        group[r].text = "$res"
        for (i in 0..4) {
            if (i == r)
                group[i].text = "$res"
        }
    }
}


