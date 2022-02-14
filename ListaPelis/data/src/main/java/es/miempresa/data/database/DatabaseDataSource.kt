package es.miempresa.data.database

import es.miempresa.domain.Film
import javax.inject.Inject

class DatabaseDataSource @Inject constructor(
    private val database:AppDatabase
) {
    suspend fun getFilms(): List<Film>{
        return database.filmDao().getFilms().map { it.toDomain() }
    }

    suspend fun getFilm(id:Int):Film? {
        return database.filmDao().getFilm(id)?.toDomain()
    }

    suspend fun updateFilms(films:List<Film>){
        database.filmDao().insertAll(films.map { it.toEntity() })
    }

    suspend fun clearFilms(){
        database.filmDao().deleteAll()
    }

    private fun FilmEntity.toDomain():Film =
        Film(
            id,
            title,
            imageUrl,
            rating,
            director,
            description,
            "",
            "",
            videoId
        )

    private fun Film.toEntity():FilmEntity =
        FilmEntity(
            id,
            title,
            urlImg,
            directorName,
            description,
            rating,
            videoId
        )
}