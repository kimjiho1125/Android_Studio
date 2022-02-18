package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class Intent2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intent2)

        var number1 = intent.getIntExtra("number1",0)
        var number2 = intent.getIntExtra("number2",0)

        Log.d("number",number1.toString())
        Log.d("number",number2.toString())

    }
}