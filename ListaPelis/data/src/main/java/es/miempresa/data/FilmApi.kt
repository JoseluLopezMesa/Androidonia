package es.miempresa.data

import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

const val BASE_URL = "https://api.themoviedb.org/3/"
const val API_KEY = "09ec48b8eb1572d60fbe4b5af38d5722"
interface FilmApi {
    @GET("movie/{id}")
    suspend fun getFilm(@Path("id")filmId:Int,
                        @Query("language")language:String,
                        @Query("api_key")apiKey:String = API_KEY):FilmDto

    @GET("movie/{id}/credits")
    suspend fun getCredits(@Path("id")filmId:Int,
                        @Query("api_key")apiKey:String = API_KEY):CreditsDto


}