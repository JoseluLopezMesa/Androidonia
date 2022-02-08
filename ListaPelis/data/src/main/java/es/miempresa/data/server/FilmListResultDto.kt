package es.miempresa.data.server

import com.google.gson.annotations.SerializedName

data class FilmListResultDto(
    @SerializedName("results") val films:List<FilmDto>
)