package com.example.notapp.core.util

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.room.TypeConverter
import java.time.LocalDateTime

class LocalDataTimeTypeConverter {

    @TypeConverter
    fun toDateString(data:LocalDateTime):String {
     data.let {
         return data.toString()

     }

    }
    @TypeConverter
    @RequiresApi(Build.VERSION_CODES.O)
    fun toLocalDataTime(dataString: String):LocalDateTime{
     dataString.let {
         return LocalDateTime.parse(it)
     }
    }


}