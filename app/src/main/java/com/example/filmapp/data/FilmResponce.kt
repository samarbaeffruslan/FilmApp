package com.example.filmapp.data


import com.google.gson.annotations.SerializedName

data class FilmResponce(
    val page: Int,
    val results: List<Result>,
    @SerializedName("total_pages")
    val totalPages: Int,
    @SerializedName("total_results")
    val totalResults: Int
)