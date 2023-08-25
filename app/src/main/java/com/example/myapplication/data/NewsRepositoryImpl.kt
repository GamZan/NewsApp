package com.example.myapplication.data

import androidx.lifecycle.MutableLiveData
import com.example.myapplication.data.api.ApiService
import com.example.myapplication.data.api.NewsDto
import com.example.myapplication.data.api.Results
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class NewsRepositoryImpl @Inject constructor(private val apiService: ApiService) {

    fun getInfo(liveData: MutableLiveData<List<Results>>) {
        val call: Call<NewsDto> = apiService.getInfo()
        call.enqueue(object : Callback<NewsDto> {
            override fun onResponse(call: Call<NewsDto>, response: Response<NewsDto>) {
                if (response.isSuccessful) {
                    liveData.postValue(response.body()?.results)
                }

            }

            override fun onFailure(call: Call<NewsDto>, t: Throwable) {
                liveData.postValue(null)
            }

        }
        )
    }
}