package com.example.worksroom.screens.start

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.worksroom.REPOSITORY
import com.example.worksroom.db.NoteDatabase
import com.example.worksroom.db.repository.NoteRealization
import com.example.worksroom.db.repository.NoteRepository
import com.example.worksroom.model.NoteModel

class StartViewModel(application: Application) : AndroidViewModel(application) {

    val context = application

    fun initDatabase() {
        val daoNote = NoteDatabase.getInstance(context).getNoteDao()
        REPOSITORY = NoteRealization(daoNote)
    }

    fun getAllNotes(): LiveData<List<NoteModel>> {
        return REPOSITORY.allNotes
    }
}