package com.tbcacademy.examcourses.network




import com.tbcacademy.examcourses.models.Topic
import com.tbcacademy.examcourses.utils.Constants.API_ENDPOINT
import retrofit2.Response
import retrofit2.http.GET


interface CoursesAPI {

    @GET(API_ENDPOINT)
    suspend fun getCourses(): Response<Topic>

}