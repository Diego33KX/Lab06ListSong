package com.diego.spotifylist

import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*

import androidx.recyclerview.widget.RecyclerView
import com.diego.spotifylist.databinding.ItemContactBinding

class ContactsAdapter(private val dataSet: List<Song>):RecyclerView.Adapter<ContactsAdapter.ViewHolder>() {
    class ViewHolder(private val binding: ItemContactBinding):
        RecyclerView.ViewHolder(binding.root){
            var picture: ImageView =binding.pictureImage
            var nombre: TextView = binding.tvNombre
            var artista: TextView = binding.tvArtista
            var genero:TextView = binding.tvGenero
            var estrella: ImageButton = binding.btnStar
            var compartir: ImageButton = binding.btnShare
            var play: ImageButton=binding.btnPlay
            var pause: ImageButton=binding.btnPause
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemBinding =ItemContactBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(itemBinding)
    }

    override fun onBindViewHolder(binding: ViewHolder, position: Int) {
        val song:Song = this.dataSet[position]
        val context = binding.itemView.context
        val idRes =context.resources.getIdentifier(song.picture,"drawable",context.packageName)
        binding.nombre.text = song.name
        binding.artista.text = song.artist
        binding.genero.text=song.gender
        binding.picture.setImageResource(idRes)

        binding.picture.setOnClickListener{
            Toast.makeText(context,"Cancion: ${song.name}",Toast.LENGTH_SHORT).show()
        }
        //BOTON DE PLAY
        binding.play.setOnClickListener {
            Toast.makeText(context,"Canción: ${song.name} interpretado por: ${song.artist}",Toast.LENGTH_SHORT).show()
        }
        //BOTON DE PAUSE
        binding.pause.setOnClickListener {
            Toast.makeText(context,"Canción: ${song.name} interpretado por: ${song.artist}",Toast.LENGTH_SHORT).show()
        }
        //BOTON PARA COMPARTIR POR WHATSAPP
        binding.compartir.setOnClickListener {
            try{
                val telefono = "973732474"
                val text = "Hola, te comparto la canción: ${song.name} interpretado por ${song.artist} del genero ${song.gender}!!!"
                val intent = Intent(Intent.ACTION_VIEW)
                intent.data = Uri.parse("http://api.whatsapp.com/send?phone=$telefono&text=$text")
                context.startActivity(intent)
            }catch (e: Exception){
                e.printStackTrace()
            }

        }
        if (song.gender=="Rock"){
            binding.estrella.visibility=View.VISIBLE
        }

    }

    override fun getItemCount(): Int = dataSet.size

}