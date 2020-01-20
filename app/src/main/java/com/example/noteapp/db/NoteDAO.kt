package com.example.noteapp.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update


@Dao
interface NoteDAO {

    @Insert
    fun addNote(note:Note)

    @Query("SELECT * FROM note ORDER BY id DESC")
    fun getAllNotes():List<Note>

    @Update
    fun updateNote(note: Note)
}