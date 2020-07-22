package com.example.futheadbackend.repository

import com.example.futheadbackend.dto.entity.Match
import org.springframework.data.jpa.repository.JpaRepository

interface MatchRepository : JpaRepository<Match, Int> {
}