package com.example.futheadbackend.repository

import com.example.futheadbackend.dto.entity.Tournament
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

interface TournamentRepository : JpaRepository<Tournament, Int> {

}