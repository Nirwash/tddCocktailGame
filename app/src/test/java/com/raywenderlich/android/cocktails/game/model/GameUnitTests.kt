package com.raywenderlich.android.cocktails.game.model

import org.junit.Assert
import org.junit.Before
import org.junit.Test

class GameUnitTests {
    private lateinit var game: Game

    @Before
    fun setup() {
        game = Game(emptyList(), 0)
    }

    @Test
    fun whenIncrementingScore_shouldIncrementCurrentScore() {
        game.incrementScore()
        val message = "Current score should have been 1"
        val expected = 1
        val actual = game.currentScore
        Assert.assertEquals(message, expected, actual)
    }

    @Test
    fun whenIncrementingScore_aboveHighScore_shouldAlsoIncrementHighScore() {
        game.incrementScore()
        val expected = 1
        val actual = game.highestScore
        Assert.assertEquals(expected, actual)
    }

    @Test
    fun whenIncrementingScore_belowHighScore_shouldNotIncrementHighScore() {
        game = Game(emptyList(), 10)
        game.incrementScore()
        val expected = 10
        val actual = game.highestScore
        Assert.assertEquals(expected, actual)
    }

    @Test
    fun whenGettingNextQuestion_shouldReturnIt() {
        val expected = Question("correct", "incorrect")
        val questions = listOf(expected)
        val game = Game(questions)
        val actual = game.nextQuestion()
        Assert.assertSame(expected, actual)
    }

    @Test
    fun whenGettingNextQuestion_withoutMoreQuestions_shouldReturnNull() {
        val question1 = Question("correct", "incorrect")
        val question2 = Question("+", "-")
        val questions = listOf(question1, question2)
        val game = Game(questions)
        game.nextQuestion()
        game.nextQuestion()
        val expected = game.nextQuestion()
        Assert.assertNull(expected)
    }


}