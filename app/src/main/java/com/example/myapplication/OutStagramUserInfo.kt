package com.example.myapplication

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class OutStagramUserInfo : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_out_stagram_user_info)

        val user_info = findViewById<TextView>(R.id.user_info)
        val all_list = findViewById<TextView>(R.id.all_list)
        val my_list = findViewById<TextView>(R.id.my_list)
        val upload = findViewById<TextView>(R.id.upload)
        val logout = findViewById<TextView>(R.id.logout)
        user_info.setOnClickListener {
            startActivity(Intent(this@OutStagramUserInfo, OutStagramUserInfo::class.java))
        }
        all_list.setOnClickListener {
            startActivity(Intent(this@OutStagramUserInfo, OutStagramPostListActivity::class.java))
        }
        my_list.setOnClickListener {
            startActivity(Intent(this@OutStagramUserInfo, OutstagramMyPostListActivity::class.java))
        }
        upload.setOnClickListener {
            startActivity(Intent(this@OutStagramUserInfo, OutStagramUploadActivity::class.java))
        }
        logout.setOnClickListener {
            val sp = getSharedPreferences("login_sp", Context.MODE_PRIVATE)
            val editor = sp.edit()
            editor.putString("login_sp","null")
            editor.commit()
            (application as MasterApplication).creteRetrofit()
            finish()
            startActivity(Intent(this@OutStagramUserInfo, LoginActivity::class.java))
        }
    }
}

