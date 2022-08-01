package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import io.realm.Realm
import io.realm.RealmConfiguration

class RealmActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_realm)

        val button_save = findViewById<Button>(R.id.button_save)
        val button_load = findViewById<Button>(R.id.button_load)
        val button_delete = findViewById<Button>(R.id.button_delete)

        Realm.init(this@RealmActivity)
        val config : RealmConfiguration = RealmConfiguration.Builder()
            .deleteRealmIfMigrationNeeded()
            .build()
        Realm.setDefaultConfiguration(config)
        val realm = Realm.getDefaultInstance()

        button_save.setOnClickListener {
            realm.executeTransaction {
                with(it.createObject(School::class.java)) {
                    this.name = "어떤 대학교"
                    this.location = "서울"
                    //데이터 생성 완료
                }
            }
        }
        button_load.setOnClickListener {
            realm.executeTransaction {
                var data = it.where(School::class.java).findFirst()
                Log.d("dataa", "data : " + data)
            }
        }
        button_delete.setOnClickListener {
            realm.executeTransaction {
                // 테이블 전체 지우기
                it.where(School::class.java).findAll().deleteAllFromRealm()
                // 첫번째 열만 지우기
                // it.where(School::class.java).findFirst().deleteFromRealm()
            }
        }
    }
}