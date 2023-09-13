package com.example.notes.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.example.notes.data.local.entity.Note
import com.example.notes.databinding.NotesListBinding

class NotesAdapter(
    val context: Context,
    val notesList: MutableLiveData<List<Note>>
): RecyclerView.Adapter<NotesAdapter.NotesViewHolder>() {

    inner class NotesViewHolder(val notesListBinding: NotesListBinding): RecyclerView.ViewHolder(notesListBinding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotesViewHolder {
        val notesListBinding = NotesListBinding.inflate(LayoutInflater.from(context))
        return NotesViewHolder(notesListBinding)
    }

    override fun getItemCount(): Int {
        return notesList.value!!.size
    }

    override fun onBindViewHolder(holder: NotesViewHolder, position: Int) {
        holder.notesListBinding.textViewTitle.text = notesList.value!!.get(position).title
        holder.notesListBinding.textViewNotes.text = notesList.value!!.get(position).description
    }
}