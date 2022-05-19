package com.flores.contactlist.model

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

data class RepositorioCanciones(val musics:MutableList<Canciones> = ArrayList()) {

    init {
        getDataMusics()
    }

    fun getDataMusics(): List<Canciones> {
        musics.add(Canciones(1, "Connexion", "Zayn", "ic_artista1", "R&B/Soul"))
        musics.add(Canciones(2, "Pluto Projector", "Rex Orange County", "ic_artista2", "Alternativa/Independiente"))
        musics.add(Canciones(3, "As It Was", "Harry Styles", "ic_artista3", "Alternativa/independiente"))
        musics.add(Canciones(4, "Do I Wanna Know", "Arctic Monkeys", "ic_artista4", "Rock"))
        musics.add(Canciones(5, "Amor sin contrato", "Gonzalo Genek", "ic_artista5", "Urbano latino"))
        musics.add(Canciones(6, "Japanese Denim", "Daniel Caesar", "ic_artista6", "Funk"))
        musics.add(Canciones(7, "BEST INTEREST", "Tyler, The Creator", "ic_artista7", "Hip-hop"))
        musics.add(Canciones(8, "ARRANCARMELO", "WOS", "ic_artista8", "Urbano latino"))
        return musics
    }
}