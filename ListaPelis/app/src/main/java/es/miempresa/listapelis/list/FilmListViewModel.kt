package es.miempresa.listapelis.list

import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import es.miempresa.domain.GetFilmListUseCase
import kotlinx.coroutines.*
import java.util.*
import javax.inject.Inject

@HiltViewModel
class FilmListViewModel @Inject constructor(private val useCase: GetFilmListUseCase
): ViewModel(),LifecycleObserver {

    private  val filmsLiveData = MutableLiveData<List<FilmItemDataView>>()
    val films: LiveData<List<FilmItemDataView>> = filmsLiveData
    var job: Job? = null

    fun loadFilms(){
        val language = Locale.getDefault().language

        job = CoroutineScope(Dispatchers.IO).launch{
            val loadedFilms = useCase.execute(language)
            withContext(Dispatchers.Main){
                loadedFilms?.let {
                    filmsLiveData.value = it.map { film ->  FilmItemDataView(film.id,film.title,film.urlImg) }
                }
            }
        }

    }

    override fun onCleared() {
        super.onCleared()
        job?.cancel()
    }
}
