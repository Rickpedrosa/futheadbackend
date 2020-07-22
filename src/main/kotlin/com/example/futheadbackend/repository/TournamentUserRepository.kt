package com.example.futheadbackend.repository

import com.example.futheadbackend.dto.entity.TournamentUser
import org.springframework.data.jpa.repository.JpaRepository

interface TournamentUserRepository : JpaRepository<TournamentUser, Int> {
}