package com.example.aa2_hangman

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.graphics.toColorInt
import androidx.core.view.get

class LevelSelect : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_level_select)
        for(i in levelIds.indices)
            SetupLevelButton(
                levelIds[i],
                getString(levelWords[i])
            );
    }

    private fun SetupLevelButton(id: Int, word: String) {
        val levelButton: LinearLayout = findViewById<LinearLayout>(id);
        StyleButton(levelButton, word);

        val bundle: Bundle = Bundle();
        bundle.putString("word", word);
        levelButton.setOnClickListener { StartGame(bundle) }
    }

    private fun StyleButton(levelButton: LinearLayout, word: String) {
        levelButton.setBackgroundColor(levelColors[word.length].toColorInt());

        val layout: LinearLayout = levelButton.getChildAt(0) as LinearLayout;

        (layout.getChildAt(0) as TextView).text =
            getString(R.string.level_button_text_word) + word;

        (layout.getChildAt(1) as TextView).text =
            getString((R.string.level_button_text_letters)) + word.length;

        (levelButton.getChildAt(1) as ImageView)
            .setImageResource(levelDrawables[word.length]);
    }

    private fun StartGame(bundle: Bundle) {
        val intent: Intent = Intent(this, Hangman::class.java);
        intent.putExtras(bundle);
        startActivity(intent);
    }
}