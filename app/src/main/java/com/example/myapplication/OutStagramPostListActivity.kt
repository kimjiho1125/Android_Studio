package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager
import org.w3c.dom.Text
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class OutStagramPostListActivity : AppCompatActivity() {

    lateinit var glide : RequestManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_out_stagram_post_list)

        glide = Glide.with(this)

        (application as MasterApplication).service.getAllPosts().enqueue(
            object : Callback<ArrayList<Post>>{
                override fun onResponse(
                    call: Call<ArrayList<Post>>,
                    response: Response<ArrayList<Post>>
                ) {
                    if(response.isSuccessful){
                        val postList = response.body()
                        val post_recyclerview = findViewById<RecyclerView>(R.id.post_recyclerview)
                        val adapter = PostAdapter(
                            postList!!,
                            LayoutInflater.from(this@OutStagramPostListActivity),
                            glide
                        )
                        post_recyclerview.adapter = adapter
                        post_recyclerview.layoutManager = LinearLayoutManager(this@OutStagramPostListActivity)
                    }
                }

                override fun onFailure(call: Call<ArrayList<Post>>, t: Throwable) {

                }
            }
        )
        val user_info = findViewById<TextView>(R.id.user_info)
        val all_list = findViewById<TextView>(R.id.all_list)
        val my_list = findViewById<TextView>(R.id.my_list)
        val upload = findViewById<TextView>(R.id.upload)
        user_info.setOnClickListener {
            startActivity(Intent(this@OutStagramPostListActivity, OutStagramUserInfo::class.java))
        }
        all_list.setOnClickListener {
            startActivity(Intent(this@OutStagramPostListActivity, OutStagramPostListActivity::class.java))
        }
        my_list.setOnClickListener {
            startActivity(Intent(this@OutStagramPostListActivity, OutstagramMyPostListActivity::class.java))
        }
        upload.setOnClickListener {
            startActivity(Intent(this@OutStagramPostListActivity, OutStagramUploadActivity::class.java))
        }
    }




    class PostAdapter(
        var postList : ArrayList<Post>,
        val inflater: LayoutInflater,
        val glide : RequestManager
    ): RecyclerView.Adapter<PostAdapter.ViewHolder>(){
        inner class ViewHolder(itemView : View): RecyclerView.ViewHolder(itemView){
            val postOwner : TextView
            val postImage : ImageView
            val postContent : TextView
            init {
                postOwner = itemView.findViewById(R.id.post_owner)
                postImage = itemView.findViewById(R.id.post_img)
                postContent = itemView.findViewById(R.id.post_content)
            }
        }
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val view = inflater.inflate(R.layout.outstargram_item_view, parent, false)
            return ViewHolder(view)
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            holder.postOwner.setText(postList.get(position).owner)
            holder.postContent.setText(postList.get(position).content)
            glide.load(postList.get(position).image).into(holder.postImage)
        }

        override fun getItemCount(): Int {
            return postList.size
        }
    }
}