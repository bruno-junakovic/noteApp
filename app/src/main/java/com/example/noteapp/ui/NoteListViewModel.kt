package com.example.noteapp.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.noteapp.application.noteApp
import com.example.noteapp.db.Note
import com.example.noteapp.db.NoteDAO
import com.example.noteapp.db.NoteDatabase

class NoteListViewModel : ViewModel() {

    private var databaseInstance:NoteDatabase
    private var noteDAO : NoteDAO

    var noteListLiveData : LiveData<List<Note>>

    init {
        this.databaseInstance = NoteDatabase.invoke(noteApp.instance.applicationContext)
        this.noteDAO = databaseInstance.getNoteDAO()
        noteListLiveData = noteDAO.getAllNotes()
    }

}