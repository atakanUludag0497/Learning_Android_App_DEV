package com.example.kelimeyibul.ui

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.kelimeyibul.data.MAX_NO_OF_WORDS
import com.example.kelimeyibul.data.SCORE_INCREASE
import com.example.kelimeyibul.data.allWords
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class GameViewModel : ViewModel(){
    // Game UI state
    private val _uiState = MutableStateFlow(GameUiState())
    val uiState: StateFlow<GameUiState> = _uiState.asStateFlow()

    var userGuess by mutableStateOf("")
        private set

    var lastScore: Int = 0
    var skipTheWord: Boolean = false

    var showSkipDialog by mutableStateOf(false)

    // Set of words used in the game
    private var usedWords: MutableSet<String> = mutableSetOf()
    private lateinit var currentWord: String

    var originalWord: String = ""

    init {
        resetGame()
    }

    fun resetGame() {
        usedWords.clear()
        _uiState.value =
            GameUiState(currentScrambledWord = pickRandomWordAndShuffle())
    }

    fun updateUserGuess(guessedWord: String) {
        userGuess = guessedWord
    }

    // Checks if the user's guess is correct.
    // Increases the score accordingly
    fun checkUserGuess() {
        if(userGuess.equals(currentWord, ignoreCase = true)) {
            // user's guess is correct,
            // increase the score and
            // call updateGameState() to prepare the game for next round
            val updatedScore = _uiState.value.score.plus(SCORE_INCREASE)
            updateGameState(updatedScore)
        }else {
            // user guess is wrong, show an error
            _uiState.update {
                it.copy(isGuessedWordWrong = true)
            }
        }
        // reset user guess
        updateUserGuess("")
    }

    // skip to next word
    fun skipWord() {
        originalWord = currentWord
        skipTheWord = true
        showSkipDialog = true
        updateGameState(_uiState.value.score)
        // reset user guess
        updateUserGuess("")
    }

    private fun updateGameState(updatedScore: Int) {
        if(usedWords.size == MAX_NO_OF_WORDS) {
            // Last round in the game, update isGameOver to true,
            // don't pick a new word
            _uiState.update {
                it.copy(
                    isGuessedWordWrong = false,
                    score = updatedScore,
                    isGameOver = true
                )
            }
        } else {
            // Normal round in the game
            _uiState.update {
                it.copy(
                    isGuessedWordWrong = false,
                    currentScrambledWord = pickRandomWordAndShuffle(),
                    currentWordCount = it.currentWordCount.inc(),
                    score = updatedScore
                )
            }
        }
    }
    private fun shuffleCurrentWord(word: String): String {
        val temporaryWord = word.toCharArray()
        // Scramble the word
        temporaryWord.shuffle()
        while (String(temporaryWord) == word) {
            temporaryWord.shuffle()
        }
        return String(temporaryWord)
    }
    private fun pickRandomWordAndShuffle(): String {
        // continue picking up a new random word until you get one that hasn't been used before
        currentWord = allWords.random()

        return if(usedWords.contains(currentWord)) {
            pickRandomWordAndShuffle()
        }else {
            usedWords.add(currentWord)
            shuffleCurrentWord(currentWord)
        }
    }
}

