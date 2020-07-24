package com.example.futheadbackend.repository

import com.example.futheadbackend.dto.entity.TournamentUserPlayer
import org.springframework.data.jpa.repository.JpaRepository

interface TournamentUserPlayerRepository : JpaRepository<TournamentUserPlayer, Int>