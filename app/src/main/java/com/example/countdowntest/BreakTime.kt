package com.example.countdowntest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.util.Log
import android.widget.Button

class BreakTime : AppCompatActivity(){
    lateinit var pause2: Button
    lateinit var reset2: Button
    lateinit var timer2: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d(MainActivity.TAG, "onCreate: e")
        widgets()
        timer2.setOnClickListener(){
            object : CountDownTimer(10000, 1) {
                override fun onTick(millisUntilFinished: Long) {
                    val sec = millisUntilFinished / 1000 + 1
                    //val sec2 = millisUntilFinished / 1000 + 1
                    timer2.text = "Timer: $sec seconds"


                }
                override fun onFinish() {
                    timer2.text = "Work Time"
                    val intent = Intent(this@BreakTime, MainActivity::class.java)
                    startActivity(intent)

                }


            }.start()
            Log.d(MainActivity.TAG, "did it save")
        }

    }


    companion object {
        // TAG is the default var name for labeling your log statements
        val TAG = "MainActivity"
    }


    private fun widgets() {
        pause2 = findViewById(R.id.button_main_pause2)
        reset2 = findViewById(R.id.button_main_reset2)
        timer2 = findViewById(R.id.button_main_timer2)
    }


}