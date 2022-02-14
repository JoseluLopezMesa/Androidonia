package es.miempresa.listapelis

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.bumptech.glide.Glide
import dagger.hilt.android.AndroidEntryPoint
import es.miempresa.listapelis.databinding.FilmActivityBinding
import es.miempresa.listapelis.detail.MainViewModel
import es.miempresa.listapelis.detail.PelisLog
import javax.inject.Inject

@AndroidEntryPoint
class FilmFragment : Fragment() {

    companion object{
        const val FILM_ID = "ID"
    }

    @Inject
    lateinit var log: PelisLog

    private lateinit var binding: FilmActivityBinding
    private val viewModel: MainViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FilmActivityBinding.inflate(layoutInflater)

        val id = arguments?.getInt(FILM_ID,0)?:512195

        binding.imageView.setImageResource(R.drawable.venom)
        binding.textView.text = resources.getString(R.string.hello)
        log.log("onCreate")

        viewModel.loadFilm(id)
        viewModel.film.observe(this){
            activity?.title = it.title
            binding.filmDirector.text = it.directorName
            binding.filmTitle.text = it.title
            binding.descriptionFilm.text = it.description
            binding.ratingBar.rating = it.rating.toFloat()/2
            Glide.with(this).load(it.urlImage).into(binding.imageView)


            if(it.videoId == null){
                binding.btnTrailer.visibility = View.GONE
            }else{
                binding.btnTrailer.visibility = View.VISIBLE
                binding.btnTrailer.setOnClickListener{_ ->
                    launchYouTube(it.videoId)
                }
            }
        }
        return binding.root
    }

    private fun launchYouTube(id:String){
        val intent= Intent(Intent.ACTION_VIEW, Uri.parse("http://www.youtube.com/watch?v=$id"))
        startActivity(intent)
    }


}