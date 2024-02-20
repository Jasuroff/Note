package com.example.notapp.core.adapter

import android.os.Build
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView
import com.example.notapp.core.entity.NoteModel
import com.example.notapp.core.util.setProrety
import com.example.notapp.databinding.ItemNoteBinding

class NoteAdapter : RecyclerView.Adapter<NoteAdapter.NoteViewHolder>() {

    private val data=ArrayList<NoteModel>()
    var onClickListener: ((id:Int)->Unit)?=null

    fun addData(data: NoteModel){
        this.data.add(data)


    }
    fun setData(data: List<NoteModel>){
        this.data.clear()
        this.data.addAll(data)
        notifyDataSetChanged()

    }

    inner class NoteViewHolder(private val binding: ItemNoteBinding) :
        RecyclerView.ViewHolder(binding.root) {
        @RequiresApi(Build.VERSION_CODES.O)
        fun bindData(data: NoteModel) {

            val date = String.format("%02d:%02d",data.date.hour,data.date.minute)

            binding.date.text=date
            binding.title.text=data.title
            binding.subTitle.text=data.subtitle
            binding.prorety.setProrety(data.prorety)
            itemView.setOnClickListener {
                onClickListener?.invoke(data.id)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        return NoteViewHolder(
            ItemNoteBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount()=data.size

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
    holder.bindData(data  [position])
    }

}