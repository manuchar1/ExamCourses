package com.tbcacademy.examcourses.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.tbcacademy.examcourses.models.Topic
import com.tbcacademy.examcourses.network.RetrofitInstance
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AllCoursesViewModel : ViewModel() {

    private val courses = MutableLiveData<Topic>().apply {
        mutableListOf<List<Topic>>()
    }

    val _coursesLiveData: LiveData<Topic> = courses

    private val loadingLiveData = MutableLiveData<Boolean>()
    val _loadingLiveData: LiveData<Boolean> = loadingLiveData

    fun init() {
        CoroutineScope(Dispatchers.IO).launch {
            getCoursesFromApi()
        }
    }


    private suspend fun getCoursesFromApi() {
        loadingLiveData.postValue(true)
        val result = RetrofitInstance.api.getCourses()
        if (result.isSuccessful) {
            val items = result.body()
            courses.postValue(items)
        }
        loadingLiveData.postValue(false)

    }
}