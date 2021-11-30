package es.miempresa.listapelis

import android.content.res.Configuration
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import dagger.hilt.android.AndroidEntryPoint
import es.miempresa.domain.GetFilmUseCase
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var log: PelisLog
    @Inject
    lateinit var film: GetFilmUseCase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        log.log("onCreate")

        val executedFilm = film.execute()
        log.log(executedFilm.title)

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