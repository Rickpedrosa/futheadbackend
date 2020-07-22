package com.example.futheadbackend.repository

import com.example.futheadbackend.dto.entity.Day
import org.springframework.data.jpa.repository.JpaRepository

interface DayRepository: JpaRepository<Day, Int> {
}