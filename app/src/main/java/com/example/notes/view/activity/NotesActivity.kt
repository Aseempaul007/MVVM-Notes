package com.example.notes.view.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.notes.R
import com.example.notes.adapter.NotesAdapter
import com.example.notes.data.local.entity.Note
import com.example.notes.databinding.ActivityNotesBinding
import com.example.notes.util.Constants
import com.example.notes.view.fragment.AddNotesFragment
import com.example.notes.view.fragment.NotesFragment
import com.example.notes.viewmodel.NotesViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

@AndroidEntryPoint
class NotesActivity : AppCompatActivity() {

    lateinit var notesBinding: ActivityNotesBinding
    lateinit var notesViewModel: NotesViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        notesBinding = ActivityNotesBinding.inflate(layoutInflater)
        setContentView(notesBinding.root)

        notesViewModel= ViewModelProvider(this).get(NotesViewModel::class.java)

        initFragment()

    }

    private fun initFragment(){
        val fm = supportFragmentManager
        val ft = fm.beginTransaction()
        ft.replace(R.id.frame,NotesFragment())
        ft.commit()
    }

}