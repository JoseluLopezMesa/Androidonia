package es.miempresa.data.database

import androidx.room.*

@Dao
interface FilmDao {
    @Query("SELECT * FROM FilmEntity")
    suspend fun getFilms(): List<FilmEntity>

    @Query("SELECT * FROM FilmEntity WHERE id LIKE :filmId")
    suspend fun getFilm(filmId:Int): FilmEntity?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(films:List<FilmEntity>)

    @Delete
    suspend fun deleteFilm(film:FilmEntity)

    @Query("DELETE FROM FilmEntity")
    suspend fun deleteAll()
}