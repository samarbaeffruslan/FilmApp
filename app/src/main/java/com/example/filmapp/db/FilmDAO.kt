package com.example.filmapp.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.filmapp.data.FilmResponce
import com.example.filmapp.data.Result

@Dao
interface FilmDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(resultFilm: Result): Long

    @Query("SELECT * FROM films")
    fun getAllFilms(): LiveData<List<Result>>

    @Delete
    suspend fun delete(resultFilm: Result)
}