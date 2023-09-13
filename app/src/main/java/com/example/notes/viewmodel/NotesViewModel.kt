package com.example.notes.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.notes.data.local.entity.Note
import com.example.notes.repository.NoteRepository
import com.example.notes.util.Constants
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class NotesViewModel @Inject constructor(
    private val noteRepository: NoteRepository
):ViewModel() {
    var currentNote = MutableLiveData<Int>()
    var notesList = MutableLiveData<ArrayList<Note>>()
    suspend fun addNote(note: Note){
        noteRepository.addNote(note)
    }
    suspend fun showAllNotes(): List<Note>{
        return noteRepository.showAllNotes()
    }
}