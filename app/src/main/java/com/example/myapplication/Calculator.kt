package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_calculator.*

class Calculator : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculator)

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
            result.setText(new)
        }
        plus.setOnClickListener {

        }

    }
}