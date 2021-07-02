package com.tbcacademy.examcourses.models


import androidx.annotation.Keep

@Keep
data class Course(
    val background_color_precent: String,
    val color: String,
    val image: String,
    val precent: String,
    val title: String
)