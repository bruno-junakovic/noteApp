package com.example.noteapp.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.example.noteapp.R
import com.example.noteapp.databinding.ActivityMainBinding
import com.example.noteapp.db.Note
import com.example.noteapp.db.NoteDatabase
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding:ActivityMainBinding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        val viewModel= ViewModelProviders.of(this).get(NoteViewModel::class.java)
        binding.noteviewmodel=viewModel

        //var adapter:NoteAdapter?=null
        var noteDatabase:NoteDatabase= NoteDatabase.invoke(this)
        //var notes:List<Note> = noteDatabase.getNoteDAO().getAllNotes()
        //adapter= NoteAdapter(this,notes)
        //lvNotes.adapter=adapter

        buAdd.setOnClickListener {
            val intent = Intent(this,AddNoteActivity::class.java)
            this.startActivity(intent)
        }


        //TODO: fix adaptrer

    }


}
