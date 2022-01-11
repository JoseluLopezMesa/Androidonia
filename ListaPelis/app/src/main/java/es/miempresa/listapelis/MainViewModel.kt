package es.miempresa.listapelis

import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import es.miempresa.domain.Film
import es.miempresa.domain.GetFilmListUseCase
import es.miempresa.domain.GetFilmUseCase
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val useCase: GetFilmUseCase
): ViewModel(),LifecycleObserver {
    private  val filmLiveData = MutableLiveData<FilmDataView>()
    val film: LiveData<FilmDataView> = filmLiveData

    fun loadFilm(){
        val loadedFilm = useCase .execute()
        filmLiveData.value = FilmDataView(loadedFilm.title,loadedFilm.directorName)
    }
}

data class  FilmDataView(val title:String,val director:String)