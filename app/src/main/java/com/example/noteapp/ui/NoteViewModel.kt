package com.example.noteapp.ui

import android.content.Context
import android.view.View
import androidx.lifecycle.ViewModel
import com.example.noteapp.db.Note
import com.example.noteapp.db.NoteDatabase


class NoteViewModel : ViewModel() {

    var title:String?=null
    var description:String?=null
    var noteListener:NoteListener?=null

    fun onClickSave(view:View){
        noteListener?.onSave()
        if (this.title.isNullOrEmpty()){
            noteListener?.onFailure("Title missing")
            return
        }
        noteListener?.onSuccess()
    }

    fun addNote(context: Context){
        var note = Note(title!!,description!!)
        NoteDatabase(context).getNoteDAO().addNote(note)
    }




}