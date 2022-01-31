package es.miempresa.listapelis.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import es.miempresa.listapelis.databinding.FilmItemBinding
import javax.inject.Inject

open class FilmViewHolder(val binding: FilmItemBinding):RecyclerView.ViewHolder(binding.root)

class FilmListAdapter @Inject constructor():ListAdapter<FilmItemDataView,FilmViewHolder>(diffUtil) {

    companion object{
        private val diffUtil = object : DiffUtil.ItemCallback<FilmItemDataView>(){
            override fun areItemsTheSame(
                oldItem: FilmItemDataView,
                newItem: FilmItemDataView
            ): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(
                oldItem: FilmItemDataView,
                newItem: FilmItemDataView
            ): Boolean {
                return oldItem == newItem
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilmViewHolder {
        return object: FilmViewHolder(FilmItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)){

        }
    }

    override fun onBindViewHolder(holder: FilmViewHolder, position: Int) {
        val film = getItem(position)
        Glide.with(holder.binding.imageRow).load(film.imageUrl).into(holder.binding.imageRow)
        holder.binding.textRow.text = film.title
    }
}