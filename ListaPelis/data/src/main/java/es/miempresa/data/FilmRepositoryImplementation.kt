package es.miempresa.data

import es.miempresa.domain.Film
import es.miempresa.domain.FilmRepository
import javax.inject.Inject


class FilmRepositoryImplementation @Inject constructor():FilmRepository {
    override fun getFilm() = Film("Venom",
                                "",
                                 0.0,
                            "")
}