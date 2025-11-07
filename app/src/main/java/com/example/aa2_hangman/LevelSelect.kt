package com.example.aa2_hangman

import android.content.Intent
import android.content.res.Resources
import android.graphics.Color
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.graphics.toColorInt
import androidx.core.view.get
import kotlin.math.min


class LevelSelect : AppCompatActivity() {

    private lateinit var toolbar: Toolbar;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_level_select)
        for(i in levelIds.indices)
            SetupLevelButton(
                levelIds[i],
                getString(levelWords[i])
            );

        toolbar = findViewById<Toolbar>(R.id.toolbar);
        setSupportActionBar(toolbar);

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.topbar, menu);
        return true;
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return if (item.itemId == R.id.light_mode) {
            this.setTheme(R.style.Theme_AA2_Hangman);
            println("light");
            true;
        } else if (item.itemId == R.id.dark_mode) {
            this.setTheme(R.style.Theme_AA2_Hangman_Night);
            println("night");
            true;
        } else {
            super.onOptionsItemSelected(item);
        }
    }

    private fun SetupLevelButton(id: Int, word: String) {
        val levelButton: LinearLayout = findViewById<LinearLayout>(id);
        StyleButton(levelButton, word);

        val bundle: Bundle = Bundle();
        bundle.putString("word", word);
        levelButton.setOnClickListener { StartGame(bundle) }
    }

    private fun StyleButton(levelButton: LinearLayout, word: String) {
        levelButton.setBackgroundColor(
            getColor(levelColors[GetDifficulty(word.length).ordinal]));

        val layout: LinearLayout = levelButton.getChildAt(0) as LinearLayout;

        (layout.getChildAt(0) as TextView).text =
            getString(R.string.level_button_text_word) + word;

        (layout.getChildAt(1) as TextView).text =
            getString((R.string.level_button_text_letters)) + word.length;

        (levelButton.getChildAt(1) as ImageView)
            .setImageResource(levelDrawables[GetDifficulty(word.length).ordinal]);
    }

    private enum class Difficulty {
        EASY,
        MEDIUM,
        HARD
    }

    private fun GetDifficulty(length: Int): Difficulty {
        if(length <= 4) return Difficulty.EASY;
        if(length <= 7) return Difficulty.MEDIUM;
        return Difficulty.HARD;
    }

    private fun StartGame(bundle: Bundle) {
        val intent: Intent = Intent(this, Hangman::class.java);
        intent.putExtras(bundle);
        startActivity(intent);
    }
}