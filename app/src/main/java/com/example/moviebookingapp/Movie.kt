package com.example.moviebookingapp

data class Movie(
    val title: String,
    val image: String,
    val certification: String,
    val description: String,
    var starring: String,
    var running_time_mins: String,
    var seats_remaining: String,
    var seats_selected: String
)