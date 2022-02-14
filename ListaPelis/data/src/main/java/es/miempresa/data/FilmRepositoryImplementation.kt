package es.miempresa.data

import es.miempresa.data.database.DatabaseDataSource
import es.miempresa.data.server.ServerDataSource
import es.miempresa.domain.Film
import es.miempresa.domain.FilmRepository
import java.lang.Exception
import javax.inject.Inject


class FilmRepositoryImplementation @Inject constructor(private val serverDataSource: ServerDataSource,
private val databaseDataSource: DatabaseDataSource):FilmRepository {
    override suspend fun getFilm(id:Int,language:String):Film? {
        return try{
            val filmFromServer =  serverDataSource.getFilm(id,language)
            databaseDataSource.updateFilms(listOf(filmFromServer))
            filmFromServer
        }catch (exception:Exception){
            databaseDataSource.getFilm(id)
        }
    }
    override suspend fun getFilmList(language: String): List<Film>? {
        return try {
            val filmsFromServer =  serverDataSource.getFilms(language)
            databaseDataSource.clearFilms()
            databaseDataSource.updateFilms(filmsFromServer)
            filmsFromServer
        }catch (exception: Exception){
             databaseDataSource.getFilms()
        }

    }
}