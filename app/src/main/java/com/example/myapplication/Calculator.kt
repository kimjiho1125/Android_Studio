package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class Calculator : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculator)

        var zero = findViewById<TextView>(R.id.zero)
        var one = findViewById<TextView>(R.id.one)
        var two = findViewById<TextView>(R.id.two)
        var three = findViewById<TextView>(R.id.three)
        var four = findViewById<TextView>(R.id.four)
        var five = findViewById<TextView>(R.id.five)
        var six = findViewById<TextView>(R.id.six)
        var seven = findViewById<TextView>(R.id.seven)
        var eight = findViewById<TextView>(R.id.eight)
        var nine = findViewById<TextView>(R.id.nine)
        var ca = findViewById<TextView>(R.id.ca)
        var plus = findViewById<TextView>(R.id.plus)
        var result = findViewById<TextView>(R.id.result)

        var new = "0"
        var old = "0"

        zero.setOnClickListener {
            new += "0"
            result.setText(new)
        }
        one.setOnClickListener {
            new += "1"
            result.setText(new)
        }
        two.setOnClickListener {
            new += "2"
            result.setText(new)
        }
        three.setOnClickListener {
            new += "3"
            result.setText(new)
        }
        four.setOnClickListener {
            new += "4"
            result.setText(new)
        }
        five.setOnClickListener {
            new += "5"
            result.setText(new)
        }
        six.setOnClickListener {
            new += "6"
            result.setText(new)
        }
        seven.setOnClickListener {
            new += "7"
            result.setText(new)
        }
        eight.setOnClickListener {
            new += "8"
            result.setText(new)
        }
        nine.setOnClickListener {
            new += "9"
            result.setText(new)
        }
        ca.setOnClickListener {
            new = "0"
            old = "0"
            result.setText("0")
        }
        plus.setOnClickListener {
            old = (old.toInt() +  new.toInt()).toString()
            new = "0"
            result.setText(old)
        }

    }
}