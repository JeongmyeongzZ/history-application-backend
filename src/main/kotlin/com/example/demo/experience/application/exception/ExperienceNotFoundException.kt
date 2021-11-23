package com.example.demo.experience.application.exception

import javassist.NotFoundException

class ExperienceNotFoundException(override val message: String) : NotFoundException(message)
