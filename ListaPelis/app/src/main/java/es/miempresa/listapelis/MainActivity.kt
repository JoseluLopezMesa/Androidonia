package es.miempresa.listapelis

import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d("joselu","onCreate")
    }

    override fun onResume() {
        super.onResume()
        Log.d("joselu","onResume")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("joselu","La actividad se ha destruido")
    }
    override fun onPause() {
        super.onPause()
        Log.d("joselu","Sale de estado visible")
    }

    override fun onStop() {
        super.onStop()
        Log.d("joselu","Sale de estado foreground")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d("joselu","onRestar")
    }

    override fun onStart() {
        super.onStart()
        Log.d("joselu","La actividad se ha creado")
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        Log.d("joselu","Hay un cambio de configuración")
    }
}