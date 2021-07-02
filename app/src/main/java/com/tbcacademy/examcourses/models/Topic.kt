package com.tbcacademy.examcourses.models


import androidx.annotation.Keep

@Keep
data class Topic(
    val color: String,
    val duration: Int,
    val title: String,
    val type: String,
    val course: List<Course>
)