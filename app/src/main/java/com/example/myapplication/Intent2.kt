package com.example.myapplication

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button

class Intent2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intent2)

        val result = findViewById<Button>(R.id.result)

        result.setOnClickListener {
            var number1 = intent.getIntExtra("number1",0)
            var number2 = intent.getIntExtra("number2",0)

            Log.d("number",number1.toString())
            Log.d("number",number2.toString())

            val result = number1 + number2
            val resultIntent = Intent()
            resultIntent.putExtra("result",result)

            setResult(Activity.RESULT_OK,resultIntent)
            finish() // -> Activity 종료
            // Intent2  -> 종료
            // Intent1                Intent1
        }

    }
}