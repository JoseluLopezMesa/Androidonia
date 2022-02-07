package es.miempresa.data

import es.miempresa.domain.Film
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject

class ServerDataSource @Inject constructor() {
    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    private val api:FilmApi = retrofit.create(FilmApi::class.java)

    suspend fun getFilm(id:Int,language:String,): Film {
        val filmDto = api.getFilm(id,language)
        val creditsDto = api.getCredits(id)
        val director = creditsDto.cast.firstOrNull{it.role == "Directing"}?.name?:""
        val image = getFullUrl(filmDto.imageUrl)

        return Film(filmDto.id,filmDto.title,image,filmDto.rating,director,filmDto.description,"","")
    }

    suspend fun getFilms(language: String):List<Film>{
        return api.getPopular(language).films.map {
            val image = getFullUrl(it.imageUrl)
            Film(it.id,it.title,image,it.rating,"",it.description,"","")
        }
    }
    private fun getFullUrl(imageUrl:String)= imageUrl?.let {
        "https://image.tmdb.org/t/p/w500$it" }
}