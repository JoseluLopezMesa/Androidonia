package es.miempresa.domain

interface FilmRepository {
    suspend fun getFilm(id:Int,language:String):Film?
    suspend fun getFilmList(language: String):List<Film>?
}