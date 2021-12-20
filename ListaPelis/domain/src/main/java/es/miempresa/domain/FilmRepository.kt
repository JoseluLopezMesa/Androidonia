package es.miempresa.domain

interface FilmRepository {
    fun getFilm():Film
    fun getFilmList():List<Film>
}