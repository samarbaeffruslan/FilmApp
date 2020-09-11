package com.example.filmapp.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.filmapp.repository.FilmRepository
import com.example.filmapp.viewmodel.FilmViewModel
import com.example.filmapp.viewmodel.FilmViewModelProviderFactory
import com.example.runningapp.R

class MainActivity : AppCompatActivity() {

    lateinit var viewModel: FilmViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val filmRepository = FilmRepository()
        val viewModelProviderFactory = FilmViewModelProviderFactory(filmRepository)

        viewModel = ViewModelProvider(this,viewModelProviderFactory).get(FilmViewModel::class.java)
    }
}