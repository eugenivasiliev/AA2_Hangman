package com.example.aa2_hangman

import android.content.res.Resources
import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Hangman : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hangman)

        val word: String? = intent.extras?.getString("word");
        val text: TextView = findViewById(R.id.textView);
        text.text = word;

        SetupKeyboard();
    }

    val keyIds: List<Int> = listOf(
        R.id.keyA, R.id.keyB, R.id.keyC, R.id.keyD, R.id.keyE,
        R.id.keyF, R.id.keyG, R.id.keyH, R.id.keyI, R.id.keyJ,
        R.id.keyK, R.id.keyL, R.id.keyM, R.id.keyN, R.id.keyO,
        R.id.keyP, R.id.keyQ, R.id.keyR, R.id.keyS, R.id.keyT,
        R.id.keyU, R.id.keyV, R.id.keyW, R.id.keyX, R.id.keyY,
        R.id.keyZ
    );

    private fun SetupKeyboard() {
        for (id in keyIds) {
            val key: TextView = findViewById(id);
            key.setOnClickListener { ProcessKey(key.text); }
        }
    }

    private fun ProcessKey(key: CharSequence) {
        println(key);
    }
}