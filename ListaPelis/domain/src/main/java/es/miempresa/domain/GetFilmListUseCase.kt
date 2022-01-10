package es.miempresa.domain

import javax.inject.Inject

class GetFilmListUseCase @Inject constructor(
    private  val repository: FilmRepository)
{
    fun execute():List<Film> {
        return repository.getFilmList()
    }
}