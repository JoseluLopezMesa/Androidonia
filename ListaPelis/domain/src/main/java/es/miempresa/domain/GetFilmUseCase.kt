package es.miempresa.domain

import javax.inject.Inject

class GetFilmUseCase @Inject constructor(
    private  val repository: FilmRepository)
{
    suspend fun execute(language:String) = repository.getFilmList(language)

}