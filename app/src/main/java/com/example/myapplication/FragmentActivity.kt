package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.fragment.app.FragmentManager

class FragmentActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment)
        Log.d("life_cycle","onCreate")

        val button = findViewById<Button>(R.id.button)
        val button2 = findViewById<Button>(R.id.button2)

        var fragmentOne : FragmentOne = FragmentOne()

        // fragment에 data를 넣어주는 방법
        val bundle : Bundle = Bundle()
        bundle.putString("hello", "hello")
        fragmentOne.arguments = bundle

        button.setOnClickListener {
            // 프라그먼트를 동적으로 작동하는 방법
            // fragment 붙이는 방법 -> replace/add
            val fragmentManager: FragmentManager = supportFragmentManager

            // Transaction
            // 작업의 단위 -> 시작과 끝이 있다
            val fragmentTransaction = fragmentManager.beginTransaction() // 시작
            fragmentTransaction.replace(R.id.container,fragmentOne) // 할일
            fragmentTransaction.commit() // 끝

            // 끝을 내는 방법
            // commit        -> 시간 될 때 하라 (좀더 안정적)
            // commitnow     -> 지금 당장 하라
        }

        button2.setOnClickListener {
            // fragment remove/detach 하는 방법
            val fragmentManager : FragmentManager = supportFragmentManager

            val fragmentTransaction = fragmentManager.beginTransaction()//시작
            fragmentTransaction.remove(fragmentOne) //할일
            fragmentTransaction.commit() // 끝
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d("life_cycle","onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d("life_cycle","onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d("life_cycle","onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d("life_cycle","onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("life_cycle","onDestroy")
    }
}