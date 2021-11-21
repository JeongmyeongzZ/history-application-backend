package com.example.history.application.exception

import javassist.NotFoundException

class HistoryNotFoundException(override val message: String) : NotFoundException(message)
