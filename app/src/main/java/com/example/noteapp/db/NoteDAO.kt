package com.example.noteapp.db

import androidx.lifecycle.LiveData
import androidx.room.*


@Dao
interface NoteDAO {

    @Insert
    suspend fun addNote(note:Note)

    @Query("SELECT * FROM note ORDER BY id DESC")
     fun getAllNotes():LiveData<List<Note>>

    @Delete
    fun deleteNote(note: Note)

}