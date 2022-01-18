package es.miempresa.data

import es.miempresa.domain.Film
import es.miempresa.domain.FilmRepository
import java.util.concurrent.ExecutionException
import javax.inject.Inject


class FilmRepositoryImplementation @Inject constructor(private val dataSource: ServerDataSource ):FilmRepository {
    override suspend fun getFilm(id:Int,language:String):Film? {
        return try {
            dataSource.getFilm(id, language)
        } catch (e: Exception) {
            null
        }
    }
    override fun getFilmList(): List<Film> {
        return emptyList()
    }
}