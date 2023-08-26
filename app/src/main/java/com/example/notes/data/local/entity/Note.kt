package com.example.notes.data.local.entity

import androidx.room.Entity
import androidx.room.OnConflictStrategy
import androidx.room.PrimaryKey

@Entity
data class Note(
    @PrimaryKey(autoGenerate = true)
    private val id: Int,
    private val title: String,
    private val description: String
)
