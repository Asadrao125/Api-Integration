package com.technado.apiintegration.interfaces

import com.technado.apiintegration.model.MyDataItem
import com.technado.apiintegration.model.PhotosModel
import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {

    @GET("posts")
    fun getData(): Call<List<MyDataItem>>

    @GET("photos")
    fun getPhotos(): Call<List<PhotosModel>>

}