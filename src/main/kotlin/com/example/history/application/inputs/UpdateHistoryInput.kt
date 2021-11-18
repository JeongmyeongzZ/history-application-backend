package com.example.history.application.inputs

import com.sun.istack.NotNull


class UpdateHistoryInput {
    fun getContent(): String? {
        return this.content;
    }

    @NotNull
    private val content: String? = null
}
