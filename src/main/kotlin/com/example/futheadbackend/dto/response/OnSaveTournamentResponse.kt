package com.example.futheadbackend.dto.response

import com.example.futheadbackend.dto.entity.Tournament

data class OnSaveTournamentResponse(
        val tournament: Tournament,
        val message: String,
        val code: Int
)