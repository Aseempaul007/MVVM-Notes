package com.example.notes.repository

import com.example.notes.data.local.dao.NoteDao
import com.example.notes.data.local.entity.Note
import javax.inject.Inject

class NoteRepository @Inject constructor(private val noteDao: NoteDao){

    suspend fun addNote(note: Note){
        noteDao.addNote(note)
    }

    suspend fun showAllNotes(): List<Note>{
        return noteDao.showAllNotes()
    }

}