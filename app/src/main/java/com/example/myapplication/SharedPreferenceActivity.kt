package com.example.myapplication

import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_shared_preference.*

class SharedPreferenceActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shared_preference)

        // SharedPreference에 저장하는 방법
        // Mode
        // - MODE_PRIVATE : 생성한 application에서만 사용 가능
        // - MODE_WORLD_READABLE : 다른 application에서 사용 가능 -> 읽을수만 있다
        // - MODE_WORLD_WRITEABLE : 다른 application에서 사용 가능 -> 기록도 가능
        // - MODE_MULTI_PROCESS : 이미 호출되어 사용중인지 체크
        // - MODE_APPEND : 기존 preference에 신규로 추가
//        val editor : SharedPreferences.Editor = SharedPreferences.edit()
//        editor.putString("hello", "안녕하세요")
//        editor.commit()

        //sp1 -> Sharedpreference
        //       (key,value) -> ("Hello", "안녕하세요")
        //sp2 -> Sharedpreference
        //       (key,value) -> ("Hello", "안녕하세요11")

        save_btn.setOnClickListener{
            val SharedPreferences = getSharedPreferences("sp1", MODE_PRIVATE)
            val editor : SharedPreferences.Editor = SharedPreferences.edit()
            editor.putString("hello", "안녕하세요")
            editor.putString("goodbye", "안녕히가세요")
            editor.commit()
        }

        load_button.setOnClickListener {
            // SharedPreference의 값을 불러오는 방법
            val sharedPreferences = getSharedPreferences("sp1", MODE_PRIVATE)
            val value1 = sharedPreferences.getString("hello", "데이터 없음1")
            val value2 = sharedPreferences.getString("goodbye", "데이터 없음2")
            Log.d("key-value","Value : " + value1)
            Log.d("key-value","Value : " + value2)
        }

        delete_button.setOnClickListener {
            val sharedPreferences = getSharedPreferences("sp1", MODE_PRIVATE)
            val editor = sharedPreferences.edit()
            editor.remove("hello")
            editor.commit()
        }

        delete_all_button.setOnClickListener {
            val sharedPreferences = getSharedPreferences("sp1", MODE_PRIVATE)
            val editor = sharedPreferences.edit()
            editor.clear()
            editor.commit()
        }
    }
}