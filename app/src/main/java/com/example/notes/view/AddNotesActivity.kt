package com.example.notes.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.notes.data.local.entity.Note
import com.example.notes.databinding.ActivityAddNotesBinding
import com.example.notes.viewmodel.AddNotesViewmodel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@AndroidEntryPoint
class AddNotesActivity : AppCompatActivity() {

    lateinit var addNotesViewmodel: AddNotesViewmodel
    lateinit var addNotesBinding: ActivityAddNotesBinding
    var i=0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        addNotesBinding= ActivityAddNotesBinding.inflate(layoutInflater)
        setContentView(addNotesBinding.root)

        addNotesViewmodel= ViewModelProvider(this).get(AddNotesViewmodel::class.java)

        addNotesBinding.imageViewSave.setOnClickListener {
            CoroutineScope(Dispatchers.IO).launch {
                addNotesViewmodel.addNote(Note(1,"Aseem","Paul"))
                //Log.d(MYTAG,addNotesViewmodel.showAllNotes().toString())
            }
        }
    }
}