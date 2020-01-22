package com.example.noteapp.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.noteapp.R
import com.example.noteapp.application.noteApp
import com.example.noteapp.db.Note
import com.example.noteapp.db.NoteDatabase
import kotlinx.android.synthetic.main.note_ticket.view.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class NotesListAdapter(private val notesList:MutableList<Note> = mutableListOf()) :RecyclerView.Adapter<RecyclerView.ViewHolder>(){

    fun updateNotes(list: List<Note>){
        notesList.clear()
        notesList.addAll(list)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =
         ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.note_ticket,parent,false))

    override fun getItemCount(): Int = notesList.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as ViewHolder).onBind(notesList[position])
    }

    class ViewHolder(val view:View) : RecyclerView.ViewHolder(view){

        fun onBind(note: Note){
            view.tvTitle.text = note.title
            view.tvContent.text = note.description
            view.ivDelete.setOnClickListener {
                GlobalScope.launch{
                    NoteDatabase(noteApp.instance.applicationContext).getNoteDAO().deleteNote(note)
                }
            }
        }

    }


}