package com.example.myapplication

import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import org.w3c.dom.Text
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val register = findViewById<Button>(R.id.register)
        val login = findViewById<Button>(R.id.loginBtn)
        val username_inputbox = findViewById<TextView>(R.id.username_inputbox)
        val password = findViewById<TextView>(R.id.password_inputbox)

        register.setOnClickListener {
            // 회원가입 페이지로 이동
            val intent = Intent(this, EmailSignupActivity::class.java)
            startActivity(intent)
        }

        login.setOnClickListener {
            val username = username_inputbox.text.toString()
            val password = password.text.toString()
            (application as MasterApplication).service.login(
                username, password
            ).enqueue(object : Callback<User>{
                override fun onResponse(call: Call<User>, response: Response<User>) {
                    if(response.isSuccessful){
                        val user = response.body()
                        val token = user!!.token!!
                        saveUserToken(token,this@LoginActivity)
                        (application as MasterApplication).creteRetrofit()
                        Toast.makeText(this@LoginActivity,"로그인 하셨습니다", Toast.LENGTH_LONG).show()
                        startActivity(
                            Intent(this@LoginActivity, OutStagramPostListActivity::class.java)
                        )
                    }
                }
                override fun onFailure(call: Call<User>, t: Throwable) {

                }
            })



        }
    }

    fun saveUserToken(token : String, activity: Activity){
        val sp = activity.getSharedPreferences("login_sp", Context.MODE_PRIVATE)
        val editor = sp.edit()
        editor.putString("login_sp",token)
        editor.commit()
    }

}