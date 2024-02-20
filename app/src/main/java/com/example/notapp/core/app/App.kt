package com.example.notapp.core.app

import android.app.Application
import android.os.Build
import android.provider.ContactsContract.CommonDataKinds.Note
import androidx.annotation.RequiresApi
import com.example.notapp.core.db.NoteDataBas

class App : Application() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate() {
        super.onCreate()
        NoteDataBas.init(this)
    }
}