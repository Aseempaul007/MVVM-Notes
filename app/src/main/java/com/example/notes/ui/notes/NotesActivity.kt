package com.example.notes.ui.notes

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.notes.R
import com.example.notes.databinding.ActivityNotesBinding
import com.example.notes.ui.addnotes.AddNotesActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NotesActivity : AppCompatActivity() {

    lateinit var notesBinding: ActivityNotesBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        notesBinding = ActivityNotesBinding.inflate(layoutInflater)
        setContentView(notesBinding.root)

        notesBinding.fabAdd.setOnClickListener{
            val i = Intent(this@NotesActivity,AddNotesActivity::class.java)
            startActivityForResult(i,101)
        }
    }
}