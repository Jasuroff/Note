package com.example.notapp.ui.home

import android.annotation.SuppressLint
import android.os.Build
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import androidx.annotation.RequiresApi
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.notapp.core.adapter.NoteAdapter
import com.example.notapp.core.base.BaseFragment
import com.example.notapp.core.db.NoteDataBas

import com.example.notapp.databinding.ScreenHomeBinding

class ScreenHome:BaseFragment(){
    private val binding by lazy { ScreenHomeBinding.inflate(layoutInflater)}
    private val adapter by lazy { NoteAdapter()}
    override fun createViwe(): View {
        return binding.root
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreated() {
       loadAdapter()
       loadAction()




    }

    private fun loadAction() {

        binding.addData.setOnClickListener {
            findNavController().navigate(ScreenHomeDirections.actionScreenHomeToScreenAdd(0,"add"))
        }

        adapter.onClickListener={id ->
            findNavController().navigate(ScreenHomeDirections.actionScreenHomeToScreenAdd(id,"edit"))
            
        }

        binding.search.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {}

            @RequiresApi(Build.VERSION_CODES.O)
            @SuppressLint("SetTextI18n")
            override fun onTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {


                var text = charSequence.toString().trim { it <= ' ' }
                if (!text.isEmpty()) {
                    val editText = NoteDataBas.getObject().dao().searchWord(text)
                    adapter.setData(editText)
                } else {
                    loadAdapter()
                }

            }

            override fun afterTextChanged(editable: Editable) {}
        })
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun loadAdapter() {

        binding.rvList.adapter=adapter
        binding.rvList.layoutManager=GridLayoutManager(context,2)
        adapter .setData(NoteDataBas.getObject().dao().findAll())
    }

}