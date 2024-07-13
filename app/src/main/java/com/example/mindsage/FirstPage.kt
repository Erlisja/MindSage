package com.example.mindsage



import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class FirstPage: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val button = findViewById<Button>(R.id.startButton)

        button.setOnClickListener {
            val intent = Intent(this, ChatPage::class.java)
            startActivity(intent)
        }

    }
}