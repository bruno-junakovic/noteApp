package com.example.noteapp.ui

import android.content.Context
import android.view.View
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.noteapp.application.noteApp
import com.example.noteapp.db.Note
import com.example.noteapp.db.NoteDatabase
import kotlinx.coroutines.launch


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
        addNote(noteApp.instance.applicationContext)
        noteListener?.onSuccess()
    }

     fun addNote(context: Context){
         var note = Note(title!!,description!!)
         viewModelScope.launch {
             NoteDatabase(context).getNoteDAO().addNote(note)
         }
    }


}