package com.example.myapplication

import android.content.Intent
import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import org.w3c.dom.Text
import java.lang.Exception

class AsyncActivity : AppCompatActivity() {
    var task : BackgroundAsyncTask? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_async)

        val start = findViewById<Button>(R.id.start)
        val stop = findViewById<Button>(R.id.stop)
        val progressbar = findViewById<ProgressBar>(R.id.progressbar)
        val ment = findViewById<TextView>(R.id.ment)

        start.setOnClickListener {
            task = BackgroundAsyncTask(progressbar, ment)
            task?.execute()
        }
        stop.setOnClickListener {
            //task?.cancel(true)
            startActivity(Intent(this, Intent2::class.java))
        }
    }

    override fun onPause() {
        task?.cancel(true)
        super.onPause()
    }
}

class BackgroundAsyncTask(
    val progressbar : ProgressBar,
    val progressText : TextView,
): AsyncTask<Int, Int, Int>() {
    // params -> doInBackground에서 사용할 타입
    // progress -> onProgressUpdate에서 사용할 타입
    // result -> onPostExecute에서 사용할 타입

    var percent : Int = 0

    override fun onPreExecute() {
        percent = 0
        progressbar.setProgress(percent)
    }

    override fun doInBackground(vararg params: Int?): Int {
        while(isCancelled() == false) {
            percent++
            Log.d("async", "percent : " + percent)
            if(percent > 100){
                break
            } else {
                publishProgress(percent)
            }
            try {
                Thread.sleep(100)
            } catch (e: Exception){
                e.printStackTrace()
            }
        }
        return percent
    }

    override fun onProgressUpdate(vararg values: Int?) {
        progressbar.setProgress(values[0] ?: 0)
        progressText.setText("퍼센트 : " + values[0])
        super.onProgressUpdate(*values)
    }

    override fun onPostExecute(result: Int?) {
        progressText.setText("작업이 완료되었습니다.")
    }

    override fun onCancelled() {
        progressbar.setProgress(0)
        progressText.setText("작업이 취소되었습니다.")
    }

}