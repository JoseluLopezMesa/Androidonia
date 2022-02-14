package es.miempresa.listapelis.detail

import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
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

        job = CoroutineScope(Dispatchers.IO).launch{
            val loadedFilm = useCase.execute(id,language)
            withContext(Dispatchers.Main){
                loadedFilm?.let{
                    filmLiveData.value = FilmDataView(
                        it.title,
                    it.directorName ?:"",
                        it.description,
                        it.urlImg,
                        it.rating,
                        it.videoId
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

data class  FilmDataView(val title:String,val directorName:String,val description: String,val urlImage:String?,val rating:Double,val videoId:String?)