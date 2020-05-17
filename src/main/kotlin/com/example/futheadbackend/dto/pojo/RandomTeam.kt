package com.example.futheadbackend.dto.pojo

import com.example.futheadbackend.dto.entity.Team

data class RandomTeam(
        var club: Team,
        var players: List<PlayerWithPositions>
)