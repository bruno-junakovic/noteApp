package com.example.noteapp.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.noteapp.R
import com.example.noteapp.adapters.NotesListAdapter
import com.example.noteapp.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var adapter: NotesListAdapter
    lateinit var viewModel:NoteListViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding:ActivityMainBinding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        viewModel= ViewModelProviders.of(this).get(NoteListViewModel::class.java)
        binding.noteviewmodel=viewModel

        recyclerViewNotes.layoutManager = LinearLayoutManager(this)
        adapter = NotesListAdapter()
        recyclerViewNotes.adapter=adapter
        bindViewModel()

        buAdd.setOnClickListener {
            val intent = Intent(this,AddNoteActivity::class.java)
            this.startActivity(intent)
        }
    }

    private fun bindViewModel(){
        viewModel.noteListLiveData.observe(this, Observer { noteList -> adapter.updateNotes(noteList) })
    }

}
