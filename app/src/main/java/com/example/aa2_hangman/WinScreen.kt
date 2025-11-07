package com.example.aa2_hangman

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar

class WinScreen : AppCompatActivity() {

    lateinit var Screen: View;
    lateinit var toolbar: Toolbar;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_win_screen)
        Screen = findViewById<View>(R.id.main);
        Screen.setOnClickListener { Restart(); }

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

    private fun Restart() {
        startActivity(Intent(this, LevelSelect::class.java));
    }
}