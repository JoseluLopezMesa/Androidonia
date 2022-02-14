package es.miempresa.data

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import es.miempresa.data.database.RoomModule
import es.miempresa.domain.FilmRepository
@Module(includes = [RoomModule::class])
@InstallIn(SingletonComponent::class)
abstract class DataModule {
    @Binds
    abstract fun bindFilmRepository(impl:FilmRepositoryImplementation):FilmRepository
}