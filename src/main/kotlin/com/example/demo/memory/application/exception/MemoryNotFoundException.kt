package com.example.demo.memory.application.exception

import javassist.NotFoundException

class MemoryNotFoundException(override val message: String) : NotFoundException(message)
