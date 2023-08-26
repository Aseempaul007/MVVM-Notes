package com.example.notes.ui.notes

import androidx.lifecycle.ViewModel
import com.example.notes.data.local.entity.Note
import com.example.notes.repository.NoteRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class NotesViewModel @Inject constructor(private val noteRepository: NoteRepository):ViewModel() {


    suspend fun addNote(note: Note){
        noteRepository.addNote(note)
    }

    suspend fun showAllNotes(): List<Note>{
        return noteRepository.showAllNotes()
    }

}