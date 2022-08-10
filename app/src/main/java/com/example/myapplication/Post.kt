package com.example.myapplication

import android.media.Image
import java.io.Serializable

class Post(
    val owner : String? = null,
    val content : String? = null,
    val image : String? = null
): Serializable