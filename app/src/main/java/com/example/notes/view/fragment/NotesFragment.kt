package com.example.notes.view.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.notes.R
import com.example.notes.adapter.NotesAdapter
import com.example.notes.data.local.entity.Note
import com.example.notes.databinding.FragmentAddNotesBinding
import com.example.notes.databinding.FragmentNotesBinding
import com.example.notes.util.Constants
import com.example.notes.viewmodel.NotesViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class NotesFragment : Fragment() {

    lateinit var binding: FragmentNotesBinding
    lateinit var notesViewModel: NotesViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentNotesBinding.inflate(inflater, container, false)
        notesViewModel = ViewModelProvider(requireActivity()).get(NotesViewModel::class.java)

        CoroutineScope(Dispatchers.IO).launch {
            notesViewModel.notesList.postValue(notesViewModel.showAllNotes() as ArrayList<Note>)
            notesViewModel.currentNote.postValue(notesViewModel.showAllNotes().size)

            Log.d(Constants.MYTAG,notesViewModel.currentNote.value.toString())
            Log.d(Constants.MYTAG,notesViewModel.notesList.value.toString())

            withContext(Dispatchers.Main){
                if(notesViewModel.currentNote.value!!>0){
                    binding.recyclerHome.adapter=NotesAdapter(requireContext(),notesViewModel.notesList as MutableLiveData<List<Note>>)
                    binding.recyclerHome.layoutManager = LinearLayoutManager(requireContext())
                }
            }
        }

        binding.fabAdd.setOnClickListener {
            goToAddNotesFragment()
        }

        return binding.root
    }

    private fun goToAddNotesFragment(){
        val fm = activity?.supportFragmentManager
        val ft = fm?.beginTransaction()
        ft?.replace(R.id.frame,AddNotesFragment())
        ft?.addToBackStack(null)
        ft?.commit()
    }



}