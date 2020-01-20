package com.example.noteapp.ui

interface NoteListener {

    fun onSave()
    fun onSuccess()
    fun onFailure(message:String)
}