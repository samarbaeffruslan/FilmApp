package com.example.filmapp.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.filmapp.data.FilmResponce
import com.example.filmapp.repository.FilmRepository
import com.example.filmapp.utils.Resource
import kotlinx.coroutines.launch
import retrofit2.Response

class FilmViewModel(
    val filmRepository: FilmRepository
) : ViewModel() {

    val popularFilm: MutableLiveData<Resource<FilmResponce>> = MutableLiveData()

    init {
        getPopularFilm()
    }

    fun getPopularFilm() = viewModelScope.launch {
        popularFilm.postValue(Resource.Loading())
        val response = filmRepository.getPopularMovie()
        popularFilm.postValue(handlePopularFilmResponse(response))

    }

    private fun handlePopularFilmResponse(response: Response<FilmResponce>): Resource<FilmResponce>? {
        if (response.isSuccessful) {
            response.body()?.let { resultResponse ->
                return Resource.Success(resultResponse)
            }
        }
        return Resource.Error(response.message())
    }
}