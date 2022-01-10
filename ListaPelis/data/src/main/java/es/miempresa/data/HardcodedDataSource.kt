package es.miempresa.data

import es.miempresa.domain.Film
import javax.inject.Inject

class HardcodedDataSource @Inject constructor() {
    fun getFilm() = Film("Venom",
        "",
        0.0,
        "",
        "",
        "",
        "")
    fun getFilmList() = listOf(getFilm())
}