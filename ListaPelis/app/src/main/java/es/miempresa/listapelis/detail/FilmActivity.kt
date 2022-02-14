package es.miempresa.listapelis.detail

import android.content.Intent
import android.content.res.Configuration
import android.net.Uri
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import dagger.hilt.android.AndroidEntryPoint
import es.miempresa.listapelis.R
import es.miempresa.listapelis.databinding.FilmActivityBinding
import javax.inject.Inject

@AndroidEntryPoint
class FilmActivity : AppCompatActivity() {

    companion object{
        const val FILM_ID = "ID"
    }

    @Inject
    lateinit var log: PelisLog

    private lateinit var binding: FilmActivityBinding
    private val viewModel: MainViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = FilmActivityBinding.inflate(layoutInflater)
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
            title = it.title

            if(it.videoId == null){
                binding.btnTrailer.visibility = View.GONE
            }else{
                binding.btnTrailer.visibility = View.VISIBLE
                binding.btnTrailer.setOnClickListener{_ ->
                    launchYouTube(it.videoId)
                }
            }
        }
        actionBar?.setDisplayHomeAsUpEnabled(true)
    }

    private fun launchYouTube(id:String){
        val intent= Intent(Intent.ACTION_VIEW, Uri.parse("http://www.youtube.com/watch?v=$id"))
        startActivity(intent)
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