package com.technado.apiintegration.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.technado.apiintegration.R
import com.technado.apiintegration.adapter.PhotosAdapter
import com.technado.apiintegration.interfaces.ApiInterface
import com.technado.apiintegration.model.MyDataItem
import com.technado.apiintegration.model.PhotosModel
import com.technado.apiintegration.utils.RetrofitInstance
import retrofit2.Call
import retrofit2.Response
import javax.security.auth.callback.Callback

class NextScreen : AppCompatActivity() {
    lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_next_screen)

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(this)
    }

    override fun onStart() {
        super.onStart()
        getPhotosData()
    }

    private fun getPhotosData() {
        val retrofitBuilder = RetrofitInstance.getRetrofit()?.create(ApiInterface::class.java)
        val retrofitData = retrofitBuilder?.getPhotos()

        retrofitData?.enqueue(object : retrofit2.Callback<List<PhotosModel>?> {
            override fun onResponse(
                call: Call<List<PhotosModel>?>?,
                response: Response<List<PhotosModel>?>?
            ) {
                val responseBody = response?.body()
                recyclerView.adapter = PhotosAdapter(applicationContext, responseBody)
                Toast.makeText(applicationContext, "" + responseBody, Toast.LENGTH_SHORT)
            }

            override fun onFailure(call: Call<List<PhotosModel>?>?, t: Throwable?) {
                Toast.makeText(applicationContext, "" + t?.message, Toast.LENGTH_SHORT)
            }
        })
    }
}