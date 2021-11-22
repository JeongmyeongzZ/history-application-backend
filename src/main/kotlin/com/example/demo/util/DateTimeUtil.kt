package com.example.demo.util

import java.text.SimpleDateFormat
import java.time.LocalDate

fun getDateByFormat(date: LocalDate, format: String): String {
    val simpleDateFormat = SimpleDateFormat(format)

    return simpleDateFormat.format(date)
}
