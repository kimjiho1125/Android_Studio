package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button

class Resource : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resource)

        val button3 = findViewById<Button>(R.id.button3)

        // 1
        val ment = resources.getString(R.string.hello)
        Log.d("ment","ment : " + ment)

        // 2
        val ment2 = getString(R.string.hello)
        Log.d("ment", "ment : " + ment)

        val color: Int = getColor(R.color.textview_color)
        Log.d("ment","ment : " + color)

        button3.setBackgroundColor(getColor(R.color.black))
    }
}