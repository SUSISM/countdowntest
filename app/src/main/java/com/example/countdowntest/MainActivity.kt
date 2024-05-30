package com.example.countdowntest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.util.Log
import android.widget.Button

class MainActivity : AppCompatActivity() {
    lateinit var pause: Button
    lateinit var reset: Button
    lateinit var timer: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d(TAG, "onCreate: e")
        widgets()

        timer.setOnClickListener(){
            object : CountDownTimer(5000, 1) {
                override fun onTick(millisUntilFinished: Long) {
                    val sec = millisUntilFinished / 1000 + 1
                    //val sec2 = millisUntilFinished / 1000 + 1
                    timer.text = "Timer: $sec seconds"


                }
                override fun onFinish() {
                    timer.text = "Break Time!"
                    val intent = Intent(this@MainActivity, BreakTime::class.java)
                    startActivity(intent)


                }




            }.start()
            Log.d(TAG, "did it save")
        }



    }
    companion object {
        // TAG is the default var name for labeling your log statements
        val TAG = "MainActivity"
    }


    private fun widgets() {
        pause = findViewById(R.id.button_main_pause2)
        reset = findViewById(R.id.button_main_reset2)
        timer = findViewById(R.id.button_main_timer2)
    }

}