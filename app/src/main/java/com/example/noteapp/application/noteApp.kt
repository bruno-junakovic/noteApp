package com.example.noteapp.application

import android.app.Application

class noteApp : Application() {
    companion object{
        lateinit var instance:Application
    }
    init {
        instance=this
    }
}