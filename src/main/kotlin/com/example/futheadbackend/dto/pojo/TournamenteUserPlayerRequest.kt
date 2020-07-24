package com.example.futheadbackend.dto.pojo

data class TournamenteUserPlayerRequest(
        val tournamentId: Int,
        val username: String,
        val players: List<Int>
)