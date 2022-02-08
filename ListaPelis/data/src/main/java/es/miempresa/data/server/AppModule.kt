package es.miempresa.data.server

import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import es.miempresa.data.DataModule

@InstallIn(SingletonComponent::class)
@Module(includes = [DataModule::class])
class AppModule {

}