package com.example.tanimaster.data.network
import com.example.tanimaster.data.network.api.MyApi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {

    private val retrofit = Retrofit.Builder()
        .baseUrl("https://api.github.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun getMyApi(): MyApi {
        return retrofit.create(MyApi::class.java)
    }
}