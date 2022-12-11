package com.example.worksroom.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.worksroom.db.dao.NoteDao
import com.example.worksroom.model.NoteModel

@Database(entities = [NoteModel::class], version = 1)
abstract class NoteDatabase : RoomDatabase() {
    abstract fun getNoteDao(): NoteDao

    companion object {
        private var dataBase: NoteDatabase? = null

        @Synchronized
        fun getInstance(context: Context): NoteDatabase {
            return if (dataBase == null) {
                dataBase = Room.databaseBuilder(context, NoteDatabase::class.java, "db").build()
                dataBase as NoteDatabase
            } else {
                dataBase as NoteDatabase
            }
        }
    }
}