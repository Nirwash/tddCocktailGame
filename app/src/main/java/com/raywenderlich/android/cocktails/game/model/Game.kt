package com.raywenderlich.android.cocktails.game.model

class Game(
    private val questions: List<Question>,
    highest: Int = 0
) {
    var currentScore = 0
        private set

    var highestScore = highest
        private set

    private var indexOfQuestion = -1

    fun incrementScore() {
        currentScore++
        if (currentScore > highestScore) highestScore = currentScore
    }

    fun nextQuestion(): Question? {
        val question = if (indexOfQuestion + 1 < questions.size) {
            indexOfQuestion++
            questions[indexOfQuestion]
        } else {
            null
        }
        return question
    }
}