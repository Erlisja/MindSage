package com.example.mindsage

import android.os.Bundle
import android.widget.EditText
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

// The main activity for the chat interface
class ChatActivity : AppCompatActivity() {

    private lateinit var chatAdapter: ChatAdapter
    private val messages = mutableListOf<ChatMessage>()
    private val ollamaClient = OllamaClient()
    private lateinit var recyclerView: RecyclerView
    private lateinit var sendButton: ImageButton
    private lateinit var editText: EditText
    private lateinit var menuButton: ImageButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.chat_page)

        recyclerView = findViewById(R.id.chat_recycler_view)
        sendButton = findViewById(R.id.send_button)
        editText = findViewById(R.id.input_text)
        menuButton = findViewById(R.id.menu_icon)

        chatAdapter = ChatAdapter(messages)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = chatAdapter


        sendButton.setOnClickListener {
            val userInput = editText.text.toString()
            if (userInput.isNotBlank()) {
                addMessage(ChatMessage(userInput, false)) // Add user message
                //this is the prompt used to generate the response only for mental health related questions
                val prompt = "You are a mental health assistant. Only answer questions related to mental health. If a question is unrelated, respond with 'I can only answer mental health-related questions.'\n\nUser: $userInput"
                sendMessageToOllama(prompt)
                editText.text.clear() // Clear the input field
            }
        }
    }

    private fun addMessage(chatMessage: ChatMessage) {
        messages.add(chatMessage)
        chatAdapter.notifyItemInserted(messages.size - 1)
        recyclerView.scrollToPosition(messages.size - 1)
    }

    private fun sendMessageToOllama(prompt: String) {
        CoroutineScope(Dispatchers.IO).launch {
            try {
                ollamaClient.streamResponse(
                    prompt,
                    onResponse = { responseFragment ->
                        CoroutineScope(Dispatchers.Main).launch {
                            val lastMessageIndex = messages.size - 1
                            if (lastMessageIndex >= 0 && messages[lastMessageIndex].isBot) {
                                messages[lastMessageIndex].text += responseFragment
                                chatAdapter.notifyItemChanged(lastMessageIndex)
                            } else {
                                addMessage(ChatMessage(responseFragment, true))
                            }
                        }
                    },
                    onComplete = {

                    },
                    onError = { e ->
                        CoroutineScope(Dispatchers.Main).launch {
                            addMessage(ChatMessage("Error: ${e.message}", true))
                        }
                    }
                )
            } catch (e: Exception) {
                withContext(Dispatchers.Main) {
                    addMessage(ChatMessage("Error: ${e.message}", true))
                }
            }
        }
    }

}
