package es.miempresa.domain

import javax.inject.Inject

class GetFilmUseCase @Inject constructor( // Quiero que la crees por mi con Inject
    private  val repository: FilmRepository)
{
    suspend fun execute(id:Int,language:String):Film? { //execute,run, etc. Devuelve la pelicula
        return repository.getFilm(id,language)
    }

}