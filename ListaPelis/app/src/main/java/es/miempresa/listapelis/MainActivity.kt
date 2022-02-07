package es.miempresa.listapelis

import android.content.res.Configuration
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import dagger.hilt.android.AndroidEntryPoint
import es.miempresa.listapelis.databinding.ActivityMainBinding
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    companion object{
        const val FILM_ID = "ID"
    }

    @Inject
    lateinit var log: PelisLog

    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val id = intent?.extras?.getInt(FILM_ID,0)?:512195

        binding.imageView.setImageResource(R.drawable.venom)
        binding.textView.text = resources.getString(R.string.hello)
        log.log("onCreate")

        viewModel.loadFilm(id)
        viewModel.film.observe(this){
            binding.filmDirector.text = it.directorName
            binding.filmTitle.text = it.title
            binding.descriptionFilm.text = it.description
            binding.ratingBar.rating = it.rating.toFloat()/2
            Glide.with(this).load(it.urlImage).into(binding.imageView)
        }
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