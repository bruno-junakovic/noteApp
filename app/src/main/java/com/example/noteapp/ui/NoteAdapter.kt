package com.example.noteapp.ui

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.example.noteapp.R
import com.example.noteapp.db.Note
import kotlinx.android.synthetic.main.activity_main.view.*
import kotlinx.android.synthetic.main.note_ticket.view.*

class NoteAdapter : BaseAdapter {

    var notes:List<Note>
    var context:Context?=null

    constructor(context: Context, notes:List<Note>):super(){
        this.notes = notes
        this.context=context
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var inflater  = context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        var myView=inflater.inflate(R.layout.note_ticket,null)
        var note = this.notes[position]

        myView.tvTitle.text=note.title
        myView.tvContent.text=note.description


        return myView
        //TODO fix
    }

    override fun getItem(position: Int): Any {
        return this.notes[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return this.notes.size
    }
}