package com.raywenderlich.android.cocktails.game.model

import org.junit.Assert
import org.junit.Before
import org.junit.Test

class QuestionUnitTests {
    private lateinit var question: Question

    @Before
    fun setup() {
        question = Question("CORRECT", "INCORRECT")
    }

    @Test
    fun whenCreationQuestion_shouldNotHaveAnsweredOption() {
        Assert.assertNull(question.answeredOption)
    }

    @Test
    fun whenAnswering_shouldHaveAnsweredOption() {
        question.answer("INCORRECT")
        val expected = "INCORRECT"
        val actual = question.answeredOption
        Assert.assertEquals(expected, actual)
    }

    @Test
    fun whenAnswering_withCorrectOption_shouldReturnTrue() {
        val result = question.answer("CORRECT")
        Assert.assertTrue(result)
    }

    @Test
    fun whenAnswering_withCorrectOption_shouldReturnFalse() {
        val result = question.answer("INCORRECT")
        Assert.assertFalse(result)
    }

    @Test(expected = IllegalArgumentException::class)
    fun whenAnswering_withInvalidOption_shouldThrowException() {
        question.answer("INVALID")
    }

    @Test
    fun whenCreatingQuestion_shouldReturnOptionsWithCustomSort() {
        val expected = listOf("INCORRECT", "CORRECT")
        val actual = question.getOptions { it.reversed() }
        Assert.assertEquals(expected, actual)
    }


}