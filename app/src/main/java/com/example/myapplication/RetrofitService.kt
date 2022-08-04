package com.example.myapplication

import retrofit2.Call
import retrofit2.http.GET

interface RetrofitService
{
    @GET("josn/students/")
    fun getStudentsList(): Call<ArrayList<PersonFromServer>>
}