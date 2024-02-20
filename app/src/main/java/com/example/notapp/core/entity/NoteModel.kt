package com.example.notapp.core.entity

import android.icu.text.CaseMap.Title
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDateTime

@Entity(tableName = "note_table")
@RequiresApi(Build.VERSION_CODES.O)

data class NoteModel constructor(

    val title:String,
    val subtitle :String,
    val description:String,
    val prorety:Int,
    val date :LocalDateTime=LocalDateTime.now()



){
   @PrimaryKey(autoGenerate = true)
    var id:Int=0
}
