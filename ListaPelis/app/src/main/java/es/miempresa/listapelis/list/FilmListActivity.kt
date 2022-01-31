package es.miempresa.listapelis.list

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import dagger.hilt.android.AndroidEntryPoint
import es.miempresa.listapelis.databinding.FilmListBinding
import javax.inject.Inject

@AndroidEntryPoint
class FilmListActivity : AppCompatActivity() {

    private lateinit var binding: FilmListBinding
    private val viewModel: FilmListViewModel by viewModels()

    @Inject
    lateinit var adapter: FilmListAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = FilmListBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.root.adapter = adapter
    }



}