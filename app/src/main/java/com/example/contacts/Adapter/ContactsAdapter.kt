package com.example.contacts.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.contacts.MainActivity
import com.example.contacts.Model.Contacts
import com.example.contacts.R


class ContactsAdapter (): RecyclerView.Adapter<ContactsAdapter.NoteHolder>() {
    private var notes: List<Contacts> = ArrayList()
    private var context:Context?=null
    constructor(context: Context):this(){

        this.context=context

    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.listitem, parent, false)
        return NoteHolder(itemView)
    }

    fun setData(data:List<Contacts>){
        this.notes=data
    }
    override fun onBindViewHolder(holder: NoteHolder, position: Int) {
        val currentNote = notes[position]
        holder.textViewTitle.text = currentNote.name.toString()
        holder.textViewDescription.text = currentNote.number.toString()
        holder.imageview.setOnClickListener {
            ( context as MainActivity).click(notes.get(position).contactId);
        }



    }

    override fun getItemCount(): Int {
        return notes.size
    }

    fun setNotes(notes: List<Contacts>) {
        this.notes = notes
        notifyDataSetChanged()
    }

    inner class NoteHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var textViewTitle: TextView = itemView.findViewById(R.id.email)
        var textViewDescription: TextView = itemView.findViewById(R.id.name)
        var imageview:ImageView=itemView.findViewById(R.id.delete)



    }
}
