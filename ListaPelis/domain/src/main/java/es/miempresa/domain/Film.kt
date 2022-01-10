package es.miempresa.domain

data class Film (
    val title: String,
    val urlImg:String,
    val rating:Double,
    val directorName:String,
    val description:String,
    val trailerUrl:String,
    val genre:String
    )