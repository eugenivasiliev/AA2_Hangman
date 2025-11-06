package com.example.aa2_hangman

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class LoseScreen : AppCompatActivity() {

    lateinit var Screen: View;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lose_screen)
        Screen = findViewById<View>(R.id.main);
        Screen.setOnClickListener { Restart(); }

    }

    private fun Restart() {
        startActivity(Intent(this, LevelSelect::class.java));
    }

}