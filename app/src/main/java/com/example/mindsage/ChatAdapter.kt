package com.example.mindsage

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ChatAdapter(private val messages: List<ChatMessage>) : RecyclerView.Adapter<ChatAdapter.ChatViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChatViewHolder {
        val layoutRes = if (viewType == MessageType.USER.ordinal) {
            R.layout.item_chat_message
        } else {
            R.layout.item_chat_message
        }
        val view = LayoutInflater.from(parent.context).inflate(layoutRes, parent, false)
        return ChatViewHolder(view)
    }

    override fun onBindViewHolder(holder: ChatViewHolder, position: Int) {
        val message = messages[position]
        holder.bind(message)
    }

    override fun getItemCount(): Int = messages.size

    override fun getItemViewType(position: Int): Int {
        return if (messages[position].isBot) {
            MessageType.BOT.ordinal
        } else {
            MessageType.USER.ordinal
        }
    }

    enum class MessageType {
        USER,
        BOT
    }

    class ChatViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val textView: TextView = itemView.findViewById(R.id.message_text)

        fun bind(message: ChatMessage) {
            textView.text = message.text
            // Here different styling based on message type are applied
            if (message.isBot) {
                // Adjust layout for bot messages
                textView.setBackgroundResource(R.drawable.bot_message_background)
            } else {
                // Adjust layout for user messages
                textView.setBackgroundResource(R.drawable.user_message_background)
            }
        }
    }
}
