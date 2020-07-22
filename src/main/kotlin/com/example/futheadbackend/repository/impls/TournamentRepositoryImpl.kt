package com.example.futheadbackend.repository.impls

import com.example.futheadbackend.dto.entity.Tournament
import com.example.futheadbackend.dto.response.OnSaveTournamentResponse

interface TournamentRepositoryImpl {
    fun createTournament(tournament: Tournament, roundTrip: Boolean, usersToPlay: List<String>): OnSaveTournamentResponse
}