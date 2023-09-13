package com.example.notes.view.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.notes.R
import com.example.notes.data.local.entity.Note
import com.example.notes.databinding.FragmentAddNotesBinding
import com.example.notes.util.Constants
import com.example.notes.viewmodel.NotesViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class AddNotesFragment : Fragment() {

    private lateinit var binding: FragmentAddNotesBinding
    lateinit var notesViewModel: NotesViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAddNotesBinding.inflate(inflater, container, false)
        notesViewModel = ViewModelProvider(requireActivity()).get(NotesViewModel::class.java)


        binding.imageViewSave.setOnClickListener {
            CoroutineScope(Dispatchers.IO).launch {

                notesViewModel.notesList.postValue(notesViewModel.showAllNotes() as ArrayList<Note>)
                notesViewModel.currentNote.postValue(notesViewModel.showAllNotes().size)

                withContext(Dispatchers.Main){
                    var size = notesViewModel.currentNote.value!! +1
                    notesViewModel.addNote(
                        Note(
                            size++,
                            binding.editTextTitle.text.toString(),
                            binding.editTextNotes.text.toString()
                        )
                    )

                }
                goToNotesFragment()
            }
        }

        return binding.root
    }

    private fun goToNotesFragment(){
        val fm = activity?.supportFragmentManager
        val ft = fm?.beginTransaction()
        ft?.replace(R.id.frame,NotesFragment())
        ft?.addToBackStack(null)
        ft?.commit()
    }

}