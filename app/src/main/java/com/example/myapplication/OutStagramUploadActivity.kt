package com.example.myapplication

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.widget.EditText
import android.widget.TextView
import com.example.myapplication.Kotlin.Kotlin.a
import okhttp3.MediaType
import okhttp3.MultipartBody
import okhttp3.RequestBody
import org.w3c.dom.Text
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.File

class OutStagramUploadActivity : AppCompatActivity() {

    lateinit var filePath: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_out_stagram_upload)

        val view_pictures = findViewById<TextView>(R.id.view_pictures)
        val upload = findViewById<TextView>(R.id.upload2)

        view_pictures.setOnClickListener {
            getPicture()
        }
        upload.setOnClickListener {
            uploadPost()
        }
    }

    fun getPicture(){
        val intent = Intent(Intent.ACTION_PICK)
        intent.setData(MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
        intent.setType("image/*")
        startActivityForResult(intent,1000)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode == 1000) {
            val uri : Uri = data!!.data!!
            filePath = getImageFilePath(uri)
            Log.d("pathh","path : " + a)
        }
    }

    fun getImageFilePath(contentUri : Uri) : String {
        var columnIndex = 0
        val projection = arrayOf(MediaStore.Images.Media.DATA)
        val cursor = contentResolver.query(contentUri, projection, null, null, null)
        if(cursor!!.moveToFirst()){
            columnIndex = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA)
        }
        return cursor.getString(columnIndex)
    }

    fun uploadPost(){
        val file = File(filePath)
        val fileRequestBody = RequestBody.create(MediaType.parse("image/*"), file)
        val part = MultipartBody.Part.createFormData("image",file.name , fileRequestBody)
        val content = RequestBody.create(MediaType.parse("text/plain"), getContent())

        (application as MasterApplication).service.uploadPost(
            part, content
        ).enqueue(object : Callback<Post>{
            override fun onResponse(call: Call<Post>, response: Response<Post>) {
                if(response.isSuccessful){
                    val post = response.body()
                    Log.d("pathh", post!!.content!!)
                }
            }

            override fun onFailure(call: Call<Post>, t: Throwable) {
                    Log.d("pathh", "Fail")
            }
        })
    }

    fun getContent(): String {
        val content_input = findViewById<EditText>(R.id.content_input)
        return content_input.text.toString()
    }
}