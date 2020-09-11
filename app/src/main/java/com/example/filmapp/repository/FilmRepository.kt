package com.example.filmapp.repository

import com.example.filmapp.api.RetrofitInstance

class FilmRepository(

) {

    suspend fun getPopularMovie() =
        RetrofitInstance.api.getPopularFilm()
}