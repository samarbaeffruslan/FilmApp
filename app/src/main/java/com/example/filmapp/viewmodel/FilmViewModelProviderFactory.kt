package com.example.filmapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.filmapp.repository.FilmRepository

class FilmViewModelProviderFactory(
    val filmRepository: FilmRepository
) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return FilmViewModel(filmRepository) as T
    }
}