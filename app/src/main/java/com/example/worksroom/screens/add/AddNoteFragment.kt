package com.example.worksroom.screens.add

import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isGone
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.worksroom.APP
import com.example.worksroom.R
import com.example.worksroom.databinding.FragmentAddNoteBinding
import com.example.worksroom.model.NoteModel

class AddNoteFragment : Fragment() {

    private lateinit var binding: FragmentAddNoteBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAddNoteBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() {
        val viewModel = ViewModelProvider(this).get(AddNoteViewModel::class.java)
        with(binding) {
            btnAddNote.setOnClickListener {
                if (addTitle.text.isEmpty() || addDesc.text.isEmpty()) {
                    Toast.makeText(
                        requireContext(),
                        "Empty title or description!",
                        Toast.LENGTH_SHORT
                    ).show()
                } else {
                    val title = addTitle.text.toString()
                    val description = addDesc.text.toString()
                    viewModel.insert(NoteModel(title = title, description = description)) {}
                    APP.navController.navigate(R.id.action_addNoteFragment_to_startFragment2)
                    Toast.makeText(requireContext(), "Saved", Toast.LENGTH_SHORT).show()
                }
            }
            btnBack.setOnClickListener {
                APP.navController.navigate(R.id.action_addNoteFragment_to_startFragment2)
            }
        }
    }
}
