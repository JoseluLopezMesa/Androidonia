package es.miempresa.domain

import javax.inject.Inject

class GetFilmUseCase @Inject constructor(
    private  val repository: FilmRepository)
{
    suspend fun execute(id:Int,language:String):Film?{
        return repository.getFilm(id,language)
    }


}