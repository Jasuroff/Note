package com.example.notapp.ui.add

import android.os.Build
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import androidx.annotation.RequiresApi
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.notapp.R
import com.example.notapp.core.base.BaseFragment
import com.example.notapp.core.db.NoteDataBas
import com.example.notapp.core.entity.NoteModel
import com.example.notapp.core.util.creatData
import com.example.notapp.databinding.ScreenAddBinding
import com.google.android.material.snackbar.Snackbar

class ScreenAdd:BaseFragment(),View.OnClickListener{

    private val binding by lazy { ScreenAddBinding.inflate(layoutInflater) }
    private var proporti=1
    private val args:ScreenAddArgs by navArgs()
    override fun createViwe(): View {
        return binding.root
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreated() {

        loadAction()
        if (args.category=="add"){
            createData()

        }else{

          editData()
        }


    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun editData() {
        val note=NoteDataBas.getObject().dao().findByid(args.id)
        binding.description.setText(note.description)
        binding.subtitle.setText(note.subtitle )
        binding.titleInput.setText(note.title)
        when(note.prorety){

            1->{
                proporti=1
                binding.prorety1.setImageResource(R.drawable.ic_check)
                binding.prorety2.setImageResource(0)
                binding.prorety3.setImageResource(0)
            }  2->{
            proporti=2
            binding.prorety1.setImageResource(0)
            binding.prorety2.setImageResource(R.drawable.ic_check)
            binding.prorety3.setImageResource(0)
        }  3->{
            proporti=3
            binding.prorety1.setImageResource(0)
            binding.prorety2.setImageResource(0)
            binding.prorety3.setImageResource(R.drawable.ic_check)

           // binding.description.addTextChangedListener(object :TextWatcher{

        }
        }

        binding.addEdit.setText("Edit part")
        binding.saveBtn.setBackgroundResource(R.drawable.save_btn_shape)

        binding.saveBtn.setOnClickListener{
            val title = binding.titleInput.text.toString()
            val subtitle = binding.subtitle.text.toString()
            val disc = binding.description.text.toString()

            if (title.isBlank()||subtitle.isBlank()||disc.isBlank()){
                Snackbar.make(binding.root,"oxirigacha toldiring",Snackbar.LENGTH_SHORT)
                    .setAction("Ok"){}
                    .show()

                return@setOnClickListener


            }


            val note = NoteModel(
                title=title,
                subtitle=subtitle,
                description=disc,
                prorety = proporti,

                )

            note.id=args.id

            NoteDataBas.getObject().dao().updateNote(note)
            findNavController().popBackStack()


        }

    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun createData() {
        binding.saveBtn.setOnClickListener{
            val title = binding.titleInput.text.toString()
            val subtitle = binding.subtitle.text.toString()
            val disc = binding.description.text.toString()

            if (title.isBlank()||subtitle.isBlank()||disc.isBlank()){
                Snackbar.make(binding.root,"oxirigacha toldiring",Snackbar.LENGTH_SHORT)
                    .setAction("Ok"){}
                        .show()

                return@setOnClickListener


            }


            val note = NoteModel(
                title=title,
                subtitle=subtitle,
                description=disc,
                prorety = proporti,



            )
            NoteDataBas.getObject().dao().saveNote(note)
            findNavController().popBackStack()


        }
    }

    private fun loadAction() {

        binding.prorety1.setOnClickListener(this)
        binding.prorety2.setOnClickListener(this)
        binding.prorety3.setOnClickListener(this)
    }

    override fun onClick(v: View?) {

        when(v?.id){
            R.id.prorety1-> {
                proporti=1
                binding.prorety1.setImageResource(R.drawable.ic_check)
                binding.prorety2.setImageResource(0)
                binding.prorety3.setImageResource(0)

            } R.id.prorety2-> {
            proporti=2
            binding.prorety1.setImageResource(0)
            binding.prorety2.setImageResource(R.drawable.ic_check)
            binding.prorety3.setImageResource(0)


            } R.id.prorety3-> {
            proporti=3
            binding.prorety1.setImageResource(0)
            binding.prorety2.setImageResource(0)
            binding.prorety3.setImageResource(R.drawable.ic_check)


            }
        }

    }

}