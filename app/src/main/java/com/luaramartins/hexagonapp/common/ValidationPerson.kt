package com.luaramartins.hexagonapp.common

import java.util.Calendar

object ValidationPerson {
    fun isValidName(name: String): Boolean {
        return name.isNotEmpty() && name.all { it.isLetter() || it.isWhitespace() } && name.length > 2
    }
    fun isValidCity(name: String): Boolean {
        return name.isNotEmpty() && name.all { it.isLetter() || it.isWhitespace() } && name.length > 2
    }

    fun isValidCpf(cpf: String): Boolean {
        val digits = cpf.replace("[^0-9]".toRegex(), "")

        if (digits.length != 11) return false

        if (digits.all { it == digits[0] }) return false

        val firstDigit = calculateDigit(digits.substring(0, 9))
        val secondDigit = calculateDigit(digits.substring(0, 10))

        return digits[9].digitToInt() == firstDigit && digits[10].digitToInt() == secondDigit
    }

    private fun calculateDigit(cpfPart: String): Int {
        val weights = if (cpfPart.length == 9) {
            intArrayOf(10, 9, 8, 7, 6, 5, 4, 3, 2)
        } else {
            intArrayOf(11, 10, 9, 8, 7, 6, 5, 4, 3, 2)
        }

        val sum = cpfPart
            .mapIndexed { index, char -> char.digitToInt() * weights[index] }
            .sum()

        val remainder = sum % 11
        return if (remainder < 2) 0 else 11 - remainder
    }

    fun isValidDate(dateString: String): Boolean {
        if (dateString.length != 10) {
            return false
        }

        val parts = dateString.split("/")
        if (parts.size != 3) {
            return false
        }

        val day: Int
        val month: Int
        val year: Int

        try {
            day = parts[0].toInt()
            month = parts[1].toInt()
            year = parts[2].toInt()
        } catch (e: NumberFormatException) {
            return false
        }

        if (month !in 1..12) {
            return false
        }

        val calendar = Calendar.getInstance().apply {
            set(year, month - 1, 1)
        }
        val maxDaysInMonth = calendar.getActualMaximum(Calendar.DAY_OF_MONTH)

        if (day !in 1..maxDaysInMonth) {
            return false
        }

        val inputDate = Calendar.getInstance().apply {
            set(year, month - 1, day, 0, 0, 0)
            set(Calendar.MILLISECOND, 0)
        }.time

        val currentDate = Calendar.getInstance().apply {
            set(Calendar.HOUR_OF_DAY, 0)
            set(Calendar.MINUTE, 0)
            set(Calendar.SECOND, 0)
            set(Calendar.MILLISECOND, 0)
        }.time

        return !inputDate.after(currentDate)
    }


}