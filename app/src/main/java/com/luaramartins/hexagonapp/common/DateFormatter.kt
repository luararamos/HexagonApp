package com.luaramartins.hexagonapp.common


object DateFormatter {
    fun formatDate(text: String, cursorPosition: Int): Pair<String, Int> {
        val digits = text.replace("\\D".toRegex(), "")
        val formatted = StringBuilder()
        var newCursorPosition = cursorPosition

        for (i in digits.indices) {
            if (i == 2 || i == 4) {
                formatted.append('/')
                if (i < cursorPosition) newCursorPosition++
            }
            formatted.append(digits[i])
        }

        // Limitar o texto formatado para "dd/MM/yyyy"
        val finalText = formatted.toString().take(10)

        // Garantir que o cursor não esteja fora do texto formatado
        if (newCursorPosition > finalText.length) {
            newCursorPosition = finalText.length
        }

        return Pair(finalText, newCursorPosition)
    }
}

