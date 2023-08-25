package com.example.myapplication.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myapplication.data.NewsRepositoryImpl
import com.example.myapplication.data.api.Results
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val newsRepositoryImpl: NewsRepositoryImpl
): ViewModel() {
    private var newsLiveData: MutableLiveData<List<Results>> = MutableLiveData()

    fun getLiveDataObserver(): MutableLiveData<List<Results>> {
        return newsLiveData
    }

    fun loadListNews() {
        newsRepositoryImpl.getInfo(newsLiveData)
    }
}