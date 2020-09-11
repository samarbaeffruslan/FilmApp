package com.example.filmapp.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.filmapp.data.Result


@Database(
    entities = [Result::class],
    version = 1
)
@TypeConverters(Converters::class)
abstract class FilmDatabase : RoomDatabase() {

    abstract fun getFilmDao(): FilmDAO

    companion object{
        @Volatile
        private var instance: FilmDatabase? = null
        private val LOCK = Any()

        operator fun invoke(context: Context) = instance ?: synchronized(LOCK) {
            instance ?: createDatabase(context).also{
                instance = it
            }
        }

        private fun createDatabase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                FilmDatabase::class.java,
                "film_db.db"
            ).build()

    }
}