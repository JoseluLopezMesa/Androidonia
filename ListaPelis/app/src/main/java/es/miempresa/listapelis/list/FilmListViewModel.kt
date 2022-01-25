package es.miempresa.listapelis.list

import android.content.ClipDescription
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
class FilmListViewModel @Inject constructor(private val useCase: GetFilmUseCase
): ViewModel(),LifecycleObserver {

    var job: Job? = null



    override fun onCleared() {
        super.onCleared()
        job?.cancel()
    }
}
