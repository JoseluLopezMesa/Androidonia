package es.miempresa.listapelis

import android.os.Bundle
import android.os.PersistableBundle
import androidx.fragment.app.FragmentActivity
import es.miempresa.listapelis.databinding.MainBinding

class MainActivity: FragmentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = MainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}