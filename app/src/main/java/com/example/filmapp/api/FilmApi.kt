package com.example.filmapp.api

import com.example.filmapp.data.FilmResponce
import com.example.filmapp.utils.Constants
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface FilmApi {

    @GET("/3/movie/popular")
    suspend fun getPopularFilm(
        @Query("api_key")
        apiKey: String = Constants.API_KEY
    ): Response<FilmResponce>
}