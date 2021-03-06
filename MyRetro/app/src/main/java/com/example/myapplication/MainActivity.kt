package com.example.myapplication

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.model.Users
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity() {
    private lateinit var rcview:RecyclerView
    lateinit var madapter:MyAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        rcview=findViewById(R.id.contents)
        madapter = MyAdapter()
        val layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(this,RecyclerView.VERTICAL,false)
        rcview.layoutManager = layoutManager
        rcview.adapter = madapter

        val service: ApiInterface = RetroFitInstance().getRetrofitInstance().create(ApiInterface::class.java)
        val call: Call<Users> = service.getUserData()
        call.enqueue(object : Callback<Users> {
            override fun onResponse(call: Call<Users>, response: Response<Users>) {

                Log.d("Repo", "${ response.code()}")
                if(response.isSuccessful)
                {
                   madapter.setofUsers(response.body()!!.data)

                    Log.d("Repo", "${response.body()?.data?.get(1)}")
                }
                else{
                    Log.d("Application", "404 Not found")
                }

            }
            override fun onFailure(call: Call<Users>, t: Throwable) {
                Log.d("Application", "Network Failure")
            }
        })
    }

}


