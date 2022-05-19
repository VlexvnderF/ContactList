package com.flores.contactlist.adapter
import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.service.autofill.Dataset
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.flores.contactlist.databinding.ActivityCancionesBinding
import com.flores.contactlist.model.Canciones
import de.hdodenhof.circleimageview.CircleImageView

class AdaptadorCancion(private val dataset: List<Canciones>)
    :  RecyclerView.Adapter<AdaptadorCancion.ViewHolder>() {
    class ViewHolder(private val binding: ActivityCancionesBinding)
        : RecyclerView.ViewHolder(binding.root) {
        var picture: ImageView = binding.pictureImage
        var nameMusic: TextView = binding.nameMusic
        var nameArtist: TextView = binding.nameArtist
        var picturePlay: CircleImageView = binding.picturePlay
        var pictureShare: CircleImageView = binding.pictureShare
        var pictureStar: CircleImageView = binding.pictureStar
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemBinding = ActivityCancionesBinding.inflate(LayoutInflater.from(parent.context),
            parent, false)
        return ViewHolder(itemBinding)
    }
    override fun onBindViewHolder(binding: ViewHolder, position: Int) {
        val music: Canciones = this.dataset[position]
        val context = binding.itemView.context
        val idRes = context.resources.getIdentifier(music.imagen,
            "drawable", context.packageName)
        binding.nameMusic.text = music.cancionNombre
        binding.nameArtist.text = music.artistNombre
        binding.picture.setImageResource(idRes)
        binding.picture.setOnClickListener {
            TODO()
        }
        if(music.genero=="rock"){
            binding.pictureStar.visibility= View.VISIBLE
        }
        binding.picturePlay.setOnClickListener {
            Toast.makeText(context, "PLAY "+music.cancionNombre, Toast.LENGTH_SHORT).show()
        }
        binding.pictureShare.setOnClickListener {

            var mobileNumber=+51956146666
            val url =
                "https://api.whatsapp.com/send?phone=${mobileNumber}&text=El%20Nombre%20de%20la%20Musica%20es%20"+music.cancionNombre

            val intent = Intent(Intent.ACTION_VIEW).apply {
                this.data = Uri.parse(url)
                this.`package` = "com.whatsapp"
            }

            try {
                context.startActivity(intent)
            } catch (ex : ActivityNotFoundException){
                Toast.makeText(context, "Whatsapp no esta instalado", Toast.LENGTH_SHORT).show()
            }
        }

    }

    override fun getItemCount(): Int = dataset.size
}