package com.example.notes.viewmodel

import androidx.lifecycle.ViewModel
import com.example.notes.data.local.entity.Note
import com.example.notes.repository.NoteRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AddNotesViewmodel @Inject constructor(private val notesRepository: NoteRepository): ViewModel() {

    suspend fun addNote(note: Note){
        notesRepository.addNote(note)
    }
    suspend fun showAllNotes(): List<Note>{
        return notesRepository.showAllNotes()
    }
}