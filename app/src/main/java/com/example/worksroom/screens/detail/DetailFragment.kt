package com.example.worksroom.screens.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.worksroom.APP
import com.example.worksroom.R
import com.example.worksroom.databinding.FragmentDetailBinding
import com.example.worksroom.model.NoteModel


@Suppress("DEPRECATION")
class DetailFragment : Fragment() {

    lateinit var binding: FragmentDetailBinding
    private lateinit var currentNote: NoteModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDetailBinding.inflate(layoutInflater, container, false)
        currentNote = arguments?.getSerializable("note") as NoteModel
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() {
        val viewModel = ViewModelProvider(this).get(DetailViewModel::class.java)
        with(binding) {
            tvTitleDetail.text = currentNote.title
            tvDescDetail.text = currentNote.description

            btnDelete.setOnClickListener {
                viewModel.delete(currentNote) {}
                APP.navController.navigate(R.id.action_detailFragment_to_startFragment)
                Toast.makeText(requireContext(), "Deleted", Toast.LENGTH_SHORT).show()
            }
            btnBack.setOnClickListener {
                APP.navController.navigate(R.id.action_detailFragment_to_startFragment)

            }
        }

    }
}