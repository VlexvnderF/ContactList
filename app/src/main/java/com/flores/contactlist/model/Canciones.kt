package com.flores.contactlist.model

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

data class Canciones(
    val id:Int,
    val cancionNombre:String,
    val artistNombre:String,
    val imagen:String,
    val genero:String
)