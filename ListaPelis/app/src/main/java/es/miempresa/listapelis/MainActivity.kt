package es.miempresa.listapelis

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
        Log.d("joselu","onDestroy")
    }
    override fun onPause() {
        super.onPause()
        Log.d("joselu","onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d("joselu","onStop")
    }
}