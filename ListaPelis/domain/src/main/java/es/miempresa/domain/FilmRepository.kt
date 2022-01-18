package es.miempresa.domain

interface FilmRepository {
    suspend fun getFilm(id:Int,language:String):Film?
    fun getFilmList():List<Film>
}