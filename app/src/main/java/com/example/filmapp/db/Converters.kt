package com.example.filmapp.db

import androidx.room.TypeConverter
import java.util.stream.Collectors

class Converters {

    @TypeConverter
    fun fromHobbies(genreIds: List<Int>): String {
        return genreIds.joinToString()
    }

    @TypeConverter
    fun toHobbies(genreIds: String): List<Int> {
        return listOf(genreIds.toInt())
    }


}

