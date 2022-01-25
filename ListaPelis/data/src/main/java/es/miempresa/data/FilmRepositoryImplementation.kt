package es.miempresa.data

import es.miempresa.domain.Film
import es.miempresa.domain.FilmRepository
import java.util.concurrent.ExecutionException
import javax.inject.Inject


class FilmRepositoryImplementation @Inject constructor(private val serverDataSource: ServerDataSource ):FilmRepository {
    override suspend fun getFilm(id:Int,language:String):Film? {
        return runCatching {
            serverDataSource.getFilm(id,language)
        }.getOrNull()
    }
    override suspend fun getFilmList(language: String): List<Film>? {
        return runCatching {
            serverDataSource.getFilms(language)
        }.getOrNull()
    }
}