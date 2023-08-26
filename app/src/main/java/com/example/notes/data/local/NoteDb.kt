package com.example.notes.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.notes.data.local.dao.NoteDao
import com.example.notes.data.local.entity.Note

@Database(
    entities = [Note::class],
    version = 1
)
abstract class NoteDb: RoomDatabase() {

    abstract fun noteDao(): NoteDao

}