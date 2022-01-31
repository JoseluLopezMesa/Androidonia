package es.miempresa.domain

import javax.inject.Inject

class GetFilmListUseCase @Inject constructor(
    private  val repository: FilmRepository)
{
    suspend fun execute(language:String): List<Film>? {
        return repository.getFilmList(language)
    }
}