package es.miempresa.listapelis

import android.content.res.Configuration
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.MutableLiveData
import com.bumptech.glide.Glide
import dagger.hilt.android.AndroidEntryPoint
import es.miempresa.domain.Film
import es.miempresa.domain.GetFilmListUseCase
import es.miempresa.domain.GetFilmUseCase
import es.miempresa.listapelis.databinding.ActivityMainBinding
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var log: PelisLog
    //@Inject
    //lateinit var film: GetFilmUseCase
    //@Inject
    //lateinit var filmList: GetFilmListUseCase
    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.imageView.setImageResource(R.drawable.venom)
        binding.textView.text = resources.getString(R.string.hello)
        log.log("onCreate")

        viewModel.loadFilm(550)
        viewModel.film.observe(this){
            binding.filmDirector.text = it.directorName
            binding.filmTitle.text = it.title
            binding.descriptionFilm.text = it.description
            binding.ratingBar.rating = it.rating.toFloat()
            Glide.with(this).load(it.urlImage).into(binding.imageView)
        }
        //val executedFilm = film.execute()
        //log.log(executedFilm.title)

        //val executeFilmList = filmList.execute()
        //log.log(executeFilmList.joinToString { "," })

        Toast.makeText(this, "Pulsa sobre Hola Mundo", Toast.LENGTH_LONG).show()
    }

    override fun onResume() {
        super.onResume()
        log.log("onResume")
    }

    override fun onDestroy() {
        super.onDestroy()
        log.log("La actividad se ha destruido")
    }
    override fun onPause() {
        super.onPause()
        log.log("Sale de estado visible")
    }

    override fun onStop() {
        super.onStop()
        log.log("Sale de estado foreground")
    }

    override fun onRestart() {
        super.onRestart()
        log.log("onRestar")
    }

    override fun onStart() {
        super.onStart()
        log.log("La actividad se ha creado")
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        log.log("Hay un cambio de configuración")
    }
}