package es.miempresa.listapelis

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import dagger.hilt.android.AndroidEntryPoint
import es.miempresa.listapelis.databinding.MainBinding

@AndroidEntryPoint
class MainActivity: FragmentActivity(),FilmLauncher {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = MainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportFragmentManager.beginTransaction()
            .add(R.id.list,FilmListFragment())
            .commit()
    }

    override fun openDatails(id:Int) {
        val fragment = FilmFragment()
        fragment.arguments = Bundle().apply {
            putInt(FilmFragment.FILM_ID,id)
        }
        supportFragmentManager.beginTransaction()
            .add(R.id.list, fragment)
            .addToBackStack("BACKSTACK")
            .commit()
    }
}