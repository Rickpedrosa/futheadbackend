package com.example.futheadbackend.repository.impls

import com.example.futheadbackend.dto.entity.Tournament
import com.example.futheadbackend.dto.response.OnSaveTournamentResponse

interface TournamentRepositoryImpl {
    fun createTournament(tournament: Tournament, usersToPlay: List<String>): OnSaveTournamentResponse
}