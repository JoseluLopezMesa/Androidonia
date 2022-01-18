package es.miempresa.listapelis

import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import es.miempresa.domain.Film
import es.miempresa.domain.GetFilmListUseCase
import es.miempresa.domain.GetFilmUseCase
import kotlinx.coroutines.*
import java.util.*
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val useCase: GetFilmUseCase
): ViewModel(),LifecycleObserver {
    private  val filmLiveData = MutableLiveData<FilmDataView>()
    val film: LiveData<FilmDataView> = filmLiveData
    var job: Job? = null

    fun loadFilm(id:Int){
        val language = Locale.getDefault().language
        //val loadedFilm = useCase .execute()
        //filmLiveData.value = FilmDataView(loadedFilm.title,loadedFilm.directorName)
        job = CoroutineScope(Dispatchers.IO).launch{
            val loadedFilm = useCase.execute(550,language)
            withContext(Dispatchers.Main){
                if(loadedFilm != null){
                    filmLiveData.value = FilmDataView(
                        loadedFilm.title,
                    loadedFilm.directorName ?:""
                    )
                }
            }

        }
    }

    override fun onCleared() {
        super.onCleared()
        job?.cancel()
    }
}

data class  FilmDataView(val title:String,val director:String)