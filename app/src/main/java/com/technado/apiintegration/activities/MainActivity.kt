package com.technado.apiintegration.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.technado.apiintegration.R
import com.technado.apiintegration.utils.RetrofitInstance
import com.technado.apiintegration.adapter.PostAdapter
import com.technado.apiintegration.interfaces.ApiInterface
import com.technado.apiintegration.model.MyDataItem
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    lateinit var recyclerView: RecyclerView
    lateinit var btnNextScreen: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)
        btnNextScreen = findViewById(R.id.btnNextScreen)
        btnNextScreen.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        })
    }

    override fun onStart() {
        super.onStart()
        getMyData()
    }

    private fun getMyData() {
        /*var dataList: MyDataItem
          val retrofitBuilder = Retrofit.Builder()
          .addConverterFactory(GsonConverterFactory.create())
          .baseUrl(resources.getString(R.string.BASE_URL))
          .build()
          .create(ApiInterface::class.java)*/

        val retrofitBuilder = RetrofitInstance.getRetrofit()?.create(ApiInterface::class.java)
        val retrofitData = retrofitBuilder?.getData()

        retrofitData?.enqueue(object : Callback<List<MyDataItem>?> {
            override fun onResponse(
                call: Call<List<MyDataItem>?>?,
                response: Response<List<MyDataItem>?>?
            ) {
                val responseBody = response?.body()
                /* val stringBuilder = StringBuilder()
                 for (myData in responseBody!!){
                     dataList = myData
                 }*/

                recyclerView.adapter = PostAdapter(applicationContext, responseBody)
                Toast.makeText(this@MainActivity, "" + response?.body(), Toast.LENGTH_SHORT).show()
            }

            override fun onFailure(call: Call<List<MyDataItem>?>?, t: Throwable?) {
                Toast.makeText(this@MainActivity, "" + t?.message, Toast.LENGTH_SHORT).show()
            }
        })
    }
}