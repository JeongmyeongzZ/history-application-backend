package com.example.history.application.history

import com.github.javafaker.Faker

interface WithFaker {
    companion object {
        val faker: Faker = Faker(Locale.KOREA)
    }
}
