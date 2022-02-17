package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_listener.*

class Listener : AppCompatActivity() {

    var number = 10

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_listener)

        // 뷰를 activity로 가져오는 방법(1)
        // - 직접 찾아서 가져온다
//        val textView : TextView = findViewById(R.id.hello)

        // 뷰를 activity로 가져오는 방법(2)
        // - xml을 import해서 가져온다다
//       hello

        // 익명함수1(축약) -> 람다 표현식
        hello.setOnClickListener {
            Log.d("Click","Click!!")
        }

        // 익명함수2 -> 위의 함수와 완전히 동일함
        hello.setOnClickListener(object : View.OnClickListener{
            override fun onClick(v: View?) {
                Log.d("Click","Click!!")
            }
        })

        // 익명함수3
        val click = object : View.OnClickListener{
            override fun onClick(v: View?) {
                Log.d("Click","Click!!")
                hello.setText("안녕하세요")
                image.setImageResource(R.drawable.radius)
                number += 10
                Log.d("number", ""+number)
            }
        }
        hello.setOnClickListener(click)


        // 뷰를 조작하는 함수들
        // 1> setText
        // 2> setImageResource



    }
}