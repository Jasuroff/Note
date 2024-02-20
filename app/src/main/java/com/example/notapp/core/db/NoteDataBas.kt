package com.example.notapp.core.db

import android.content.Context
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverter
import androidx.room.TypeConverters
import com.example.notapp.core.entity.NoteModel
import com.example.notapp.core.util.LocalDataTimeTypeConverter

@RequiresApi(Build.VERSION_CODES.O)
@Database(entities = [NoteModel::class], version = 1)
@TypeConverters(value = [LocalDataTimeTypeConverter::class])
abstract class NoteDataBas : RoomDatabase() {


    companion object {

        private var db: NoteDataBas? = null

        fun init(context: Context) {
            if (db == null
            ) {
                db = Room.databaseBuilder(
                    context = context,
                    klass = NoteDataBas::class.java,
                    name = "note-db"
                ).allowMainThreadQueries().build()

            }

        }
        fun getObject():NoteDataBas {
            return db!!

        }


    }

     abstract fun dao( ) :NoteDao


}