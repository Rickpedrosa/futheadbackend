package com.example.futheadbackend.dto.pojo

data class MatchUpdateRequest(
        val id: Int,
        val timeStart: String,
        val timeEnd: String,
        val scoreHome: Int,
        val scoreAway: Int,
        val idEvent: Int,
        val idType: String
)