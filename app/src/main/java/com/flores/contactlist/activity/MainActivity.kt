package com.flores.contactlist.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.app.Activity
import com.flores.contactlist.adapter.AdaptadorCancion
import com.flores.contactlist.databinding.ActivityMainBinding
import com.flores.contactlist.model.RepositorioCanciones


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var contactListRecyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        setRecyclerView()
    }

    private fun setRecyclerView() {
        contactListRecyclerView = binding.contactsList
        contactListRecyclerView.layoutManager = LinearLayoutManager(this)
        val musics = RepositorioCanciones()
        val adapter = AdaptadorCancion(musics.musics)
        contactListRecyclerView.adapter = adapter
    }
}