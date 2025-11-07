package com.example.aa2_hangman

import android.content.Intent
import android.media.Image
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar

class Hangman : AppCompatActivity() {

    lateinit var toolbar: Toolbar;

    lateinit var word_to_guess: String;
    lateinit var guessedLetters: MutableSet<Char>;
    lateinit var text: TextView;
    lateinit var image: ImageView;

    var imageIndex: Int = 0;

    val images: List<Int> = listOf<Int>(
        R.drawable.ic_launcher_foreground,
        R.drawable.ic_launcher_background
    );

    val keyIds: List<Int> = listOf<Int>(
        R.id.keyA, R.id.keyB, R.id.keyC, R.id.keyD, R.id.keyE,
        R.id.keyF, R.id.keyG, R.id.keyH, R.id.keyI, R.id.keyJ,
        R.id.keyK, R.id.keyL, R.id.keyM, R.id.keyN, R.id.keyO,
        R.id.keyP, R.id.keyQ, R.id.keyR, R.id.keyS, R.id.keyT,
        R.id.keyU, R.id.keyV, R.id.keyW, R.id.keyX, R.id.keyY,
        R.id.keyZ
    );


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hangman)

        guessedLetters = mutableSetOf<Char>();
        word_to_guess = GetGameWord();
        text = findViewById<TextView>(R.id.text);
        image = findViewById<ImageView>(R.id.image);

        UpdateWord();
        SetupKeyboard();

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

    private fun GetGameWord(): String {
        var str: String? = intent.extras?.getString("word");
        str?.let { return str; }
        throw Exception("Level word doesn't exist!");
    }

    private fun UpdateWord() {
        var newText: String = "";
        for(letter in word_to_guess) {
            if(letter in guessedLetters) newText += letter;
            else newText += '_';
        }
        if(newText == word_to_guess) Win();
        else text.text = newText;
    }

    private fun UpdateImage(letter: Char) {
        if(letter in word_to_guess) return;

        imageIndex++;
        if(imageIndex == images.size - 1) Lose();
        else image.setImageResource(images[imageIndex]);

    }

    private fun SetupKeyboard() {
        for (id in keyIds) {
            val key: TextView = findViewById<TextView>(id);

            //We pass in only the first letter since it's a single letter key
            key.setOnClickListener { ProcessKey(key.text.first()); };
        }
    }

    private fun ProcessKey(letter: Char) {
        guessedLetters.add(letter);
        UpdateWord();
        UpdateImage(letter);
    }

    private fun Win() {
        startActivity(Intent(this, WinScreen::class.java));
    }

    private fun Lose() {
        startActivity(Intent(this, LoseScreen::class.java));
    }
}