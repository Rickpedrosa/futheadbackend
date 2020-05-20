package com.example.futheadbackend.repository

import com.example.futheadbackend.dto.entity.Tournament
import org.springframework.data.jpa.repository.JpaRepository

interface TournamentRepository : JpaRepository<Tournament, Int> {

}