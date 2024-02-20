package com.example.notapp.core.db

import android.provider.ContactsContract.CommonDataKinds.Note
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.notapp.core.entity.NoteModel

@Dao
interface NoteDao {

    @Query("SELECT * FROM note_table")
    fun findAll():List<NoteModel>

    @Query("SELECT *FROM note_table WHERE id=:id")
    fun findByid(id:Int):NoteModel

    @Insert(onConflict =OnConflictStrategy.IGNORE )
    fun saveNote(note :NoteModel)
    @Update
     fun updateNote(note: NoteModel)

     @Query("SELECT * FROM note_table WHERE title LIKE :word||'%'")
     fun searchWord(word:String) : List<NoteModel>
}