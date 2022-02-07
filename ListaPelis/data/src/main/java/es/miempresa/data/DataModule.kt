package es.miempresa.data

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import es.miempresa.domain.FilmRepository

@InstallIn(SingletonComponent::class) //Con el modulo crea un paquete, los obj del repositorio
@Module //Crea un paquete para hilt
abstract class DataModule {
    @Binds
    abstract fun bindFilmRepository(impl:FilmRepositoryImplementation):FilmRepository //Toma FilmRepositoryImplementation en vez de FilmRepository
}