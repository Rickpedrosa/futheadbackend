package com.example.futheadbackend.dto.response

import com.example.futheadbackend.dto.entity.Tournament

data class OnSaveTournamentResponse(
        val data: DataTournament
)

data class DataTournament(
        val tournament: TournamentResponse,
        val days: List<DayResponse>
)

data class DayResponse(
        val id: Int,
        val dayDate: String,
        val matches: List<MatchResponse>
)

data class TournamentResponse(
        val tournament: Tournament,
        val users: List<String>
)

data class MatchResponse(
        val id: Int,
        val dayId: Int,
        val timeStart: String,
        val timeEnd: String,
        val scoreHome: Int,
        val scoreAway: Int,
        val idEvent: Int,
        val idType: String,
        val participantHome: String,
        val participantAway: String
)