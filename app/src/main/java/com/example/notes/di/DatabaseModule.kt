package com.example.notes.di

import android.content.Context
import androidx.room.Room
import com.example.notes.data.local.NoteDb
import com.example.notes.data.local.dao.NoteDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {

    @Singleton
    @Provides
    fun getRoomDbIns(@ApplicationContext context: Context): NoteDb{
        synchronized(this){
            return Room.databaseBuilder(
                context,
                NoteDb::class.java,
                "notes_db"
            ).build()
        }
    }

    @Provides
    @Singleton
    fun getNotesDao(noteDb: NoteDb): NoteDao{
        return noteDb.noteDao()
    }
}