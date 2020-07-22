package com.example.futheadbackend.dto.pojo

data class TournamentRequest(
        val tournamentName: String,
        val type: String,
        val creationDate: String,
        val roundTrip: Boolean,
        val users: List<String>
)