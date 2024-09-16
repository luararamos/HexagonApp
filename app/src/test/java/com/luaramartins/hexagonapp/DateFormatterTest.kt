package com.luaramartins.hexagonapp

import com.luaramartins.hexagonapp.common.DateFormatter
import org.junit.Assert.assertEquals
import org.junit.Test

class DateFormatterTest {

    @Test
    fun testFormatDateWithoutFormatting() {
        val input = "01012023"
        val cursorPosition = 4
        val (formatted, newCursorPosition) = DateFormatter.formatDate(input, cursorPosition)

        assertEquals("01/01/2023", formatted)
        assertEquals(5, newCursorPosition)
    }

    @Test
    fun testFormatDateWithCursorAtEnd() {
        val input = "01012023"
        val cursorPosition = 8
        val (formatted, newCursorPosition) = DateFormatter.formatDate(input, cursorPosition)

        assertEquals("01/01/2023", formatted)
        assertEquals(10, newCursorPosition)
    }

    @Test
    fun testFormatDateWithEmptyInput() {
        val input = ""
        val cursorPosition = 0
        val (formatted, newCursorPosition) = DateFormatter.formatDate(input, cursorPosition)

        assertEquals("", formatted)
        assertEquals(0, newCursorPosition)
    }

    @Test
    fun testFormatDateWithCursorOutOfBounds() {
        val input = "01012023"
        val cursorPosition = 15
        val (formatted, newCursorPosition) = DateFormatter.formatDate(input, cursorPosition)

        assertEquals("01/01/2023", formatted)
        assertEquals(10, newCursorPosition)
    }
}
