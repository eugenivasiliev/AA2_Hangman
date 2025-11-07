package com.example.aa2_hangman

val levelIds: List<Int> = listOf(
    R.id.level1_button,
    R.id.level2_button,
    R.id.level3_button,
    R.id.level4_button,
    R.id.level5_button,
    R.id.level6_button,
    R.id.level7_button,
    R.id.level8_button
);

val levelWords: List<Int> = listOf(
    R.string.level1_word,
    R.string.level2_word,
    R.string.level3_word,
    R.string.level4_word,
    R.string.level5_word,
    R.string.level6_word,
    R.string.level7_word,
    R.string.level8_word,
);

val levelDrawables: List<Int> = listOf(
    R.drawable.ic_launcher_background,
    R.drawable.ic_launcher_foreground,
    R.drawable.ic_launcher_foreground,
    R.drawable.ic_launcher_foreground,
    R.drawable.ic_launcher_foreground
);

val levelColors: List<Int> = listOf(
    //1-4 letters
    R.color.difficulty_easy,
    //5-7 letters
    R.color.difficulty_medium,
    //7+ letters
    R.color.difficulty_hard
);