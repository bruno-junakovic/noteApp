package com.example.noteapp.ui


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.example.noteapp.R
import com.example.noteapp.databinding.ActivityAddNoteBinding
import com.example.noteapp.utils.toast
import kotlinx.android.synthetic.main.activity_add_note.*

class AddNoteActivity : AppCompatActivity(),NoteListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding :ActivityAddNoteBinding = DataBindingUtil.setContentView(this,R.layout.activity_add_note)
        val viewModel=ViewModelProviders.of(this).get(NoteViewModel::class.java)
        binding.viewmodel=viewModel
        viewModel.noteListener = this
    }

    override fun onSave() {
        toast("Saving changes")
    }

    override fun onSuccess() {

        toast("Note saved")
    }

    override fun onFailure(message: String) {
        toast(message)
    }
}
