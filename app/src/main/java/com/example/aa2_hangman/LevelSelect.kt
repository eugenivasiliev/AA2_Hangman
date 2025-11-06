package com.example.aa2_hangman

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.WindowId
import android.widget.LinearLayout
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class LevelSelect : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_level_select)
        SetupLevelButton(R.id.level1_button, getString(R.string.level1));
        SetupLevelButton(R.id.level2_button, getString(R.string.level2));
        SetupLevelButton(R.id.level3_button, getString(R.string.level3));
        SetupLevelButton(R.id.level4_button, getString(R.string.level4));
        SetupLevelButton(R.id.level5_button, getString(R.string.level5));
        SetupLevelButton(R.id.level6_button, getString(R.string.level6));
        SetupLevelButton(R.id.level7_button, getString(R.string.level7));
        SetupLevelButton(R.id.level8_button, getString(R.string.level8));
    }

    private fun SetupLevelButton(id: Int, word: String) {
        val levelButton: LinearLayout = findViewById(id);
        println(id);
        val bundle: Bundle = Bundle();
        bundle.putString("word", word);
        levelButton.setOnClickListener { StartGame(bundle) }
    }

    private fun StartGame(bundle: Bundle) {
        val intent: Intent = Intent(this, Hangman::class.java);
        intent.putExtras(bundle);
        startActivity(intent);
    }
}