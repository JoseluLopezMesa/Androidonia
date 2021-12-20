package es.miempresa.data

import es.miempresa.domain.Film
import es.miempresa.domain.FilmRepository
import javax.inject.Inject


class FilmRepositoryImplementation @Inject constructor(private val dataSource: HardcodedDataSource ):FilmRepository {
    override fun getFilm() = dataSource.getFilm()
}