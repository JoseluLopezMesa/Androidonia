package es.miempresa.listapelis.list

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import dagger.hilt.android.AndroidEntryPoint
import es.miempresa.listapelis.detail.FilmActivity
import es.miempresa.listapelis.detail.PelisLog
import es.miempresa.listapelis.databinding.FilmListBinding
import javax.inject.Inject

@AndroidEntryPoint
class FilmListActivity : AppCompatActivity() {

    @Inject
    lateinit var myLog: PelisLog

    @Inject
    lateinit var adapter: FilmListAdapter
    private lateinit var binding: FilmListBinding
    private val viewModel: FilmListViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = FilmListBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.root.adapter = adapter

        viewModel.loadFilms()

        viewModel.films.observe(this){
            adapter.submitList(it)
        }
        adapter.callBack = {
            myLog.log("Click en pelicula${it.title}")

            val intent = Intent(this, FilmActivity::class.java)
            intent.putExtra(FilmActivity.FILM_ID,it.id)
            startActivity(intent)
        }
    }



}