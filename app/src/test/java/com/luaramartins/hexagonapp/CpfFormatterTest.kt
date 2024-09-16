package com.luaramartins.hexagonapp

import com.luaramartins.hexagonapp.common.CpfFormatter
import org.junit.Assert.assertEquals
import org.junit.Test

class CpfFormatterTest {

    @Test
    fun testFormatCpfWithoutFormatting() {
        val input = "12345678900"
        val cursorPosition = 5
        val (formatted, newCursorPosition) = CpfFormatter.formatCpf(input, cursorPosition)

        assertEquals("123.456.789-00", formatted)
        assertEquals(6, newCursorPosition)
    }

    @Test
    fun testFormatCpfWithCursorAtEnd() {
        val input = "12345678900"
        val cursorPosition = 11
        val (formatted, newCursorPosition) = CpfFormatter.formatCpf(input, cursorPosition)

        assertEquals("123.456.789-00", formatted)
        assertEquals(14, newCursorPosition)
    }


    @Test
    fun testFormatCpfWithEmptyInput() {
        val input = ""
        val cursorPosition = 0
        val (formatted, newCursorPosition) = CpfFormatter.formatCpf(input, cursorPosition)

        assertEquals("", formatted)
        assertEquals(0, newCursorPosition)
    }

    @Test
    fun testFormatCpfWithCursorOutOfBounds() {
        val input = "12345678900"
        val cursorPosition = 15
        val (formatted, newCursorPosition) = CpfFormatter.formatCpf(input, cursorPosition)

        assertEquals("123.456.789-00", formatted)
        assertEquals(14, newCursorPosition)
    }
}
