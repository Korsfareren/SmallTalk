package com.example.smalltalk

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import java.time.LocalDateTime
import java.util.*

class MessageAdapter(
    private val dataSet: List<String>,
    private val clickCallback: () -> Unit
) : RecyclerView.Adapter<MessageAdapter.ChatViewHolder>() {


    //Hvordan cellen skal se ut
    inner class ChatViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val container: ConstraintLayout
        val chat: TextView
        val sender: TextView
        val date: TextView

        init {
            container = view.findViewById(R.id.cell_container)
            chat = view.findViewById(R.id.cell_chat)
            sender = view.findViewById(R.id.cell_sender)
            date = view.findViewById(R.id.cell_date)
        }
    }

    //Hva skal skje når du oppretter en celle
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChatViewHolder {
        val cellView = LayoutInflater.from(parent.context).inflate(R.layout.text_row_item, parent, false)

        return ChatViewHolder(cellView)
    }

    //Hva skal skje når du oppdaterer innholdet i en celle
    override fun onBindViewHolder(holder: ChatViewHolder, position: Int) {
        val sentMessages = dataSet[position]

        
        holder.chat.text = sentMessages
    }

    //Hvor mange items har du totalt
    override fun getItemCount(): Int {
        return dataSet.size
    }
}