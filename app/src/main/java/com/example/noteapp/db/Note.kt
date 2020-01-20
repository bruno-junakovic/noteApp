package com.example.noteapp.db

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
data class Note (
    val title:String,
    val description:String
){
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}