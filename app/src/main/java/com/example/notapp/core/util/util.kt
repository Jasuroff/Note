package com.example.notapp.core.util

import android.graphics.Color
import android.os.Build
import android.provider.ContactsContract.CommonDataKinds.Note
import androidx.annotation.RequiresApi
import com.example.notapp.core.db.NoteDataBas
import com.example.notapp.core.entity.NoteModel
import com.google.android.material.imageview.ShapeableImageView
import kotlin.random.Random

var id=0

@RequiresApi(Build.VERSION_CODES.O)
fun creatData(): NoteModel{

   var a=NoteModel("title${id}","sub","dir", Random.nextInt(1,4))
    a.id=id++
    return a

}


fun ShapeableImageView.setProrety( prorety:Int){


    when(prorety){

        1->
            this.setBackgroundColor(Color.RED)

        2->
            this.setBackgroundColor(Color.GREEN)

        3->
            this.setBackgroundColor(Color.YELLOW)


    }

}