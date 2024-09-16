package com.luaramartins.hexagonapp.common

object CpfFormatter {

    fun formatCpf(text: String, cursorPosition: Int): Pair<String, Int> {
        val digits = text.replace("\\D".toRegex(), "")
        val formatted = StringBuilder()
        var newCursorPosition = cursorPosition

        for (i in digits.indices) {
            if (i == 3 || i == 6) {
                formatted.append('.')
                if (i < cursorPosition) newCursorPosition++
            } else if (i == 9) {
                formatted.append('-')
                if (i < cursorPosition) newCursorPosition++
            }
            formatted.append(digits[i])
        }


        val finalText = formatted.toString().take(14)

        if (newCursorPosition > finalText.length) {
            newCursorPosition = finalText.length
        }

        return Pair(finalText, newCursorPosition)
    }
}