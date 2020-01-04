package com.example.futheadbackend.dto.pojo

import com.example.futheadbackend.dto.contract.PlayerContract
import com.example.futheadbackend.dto.contract.TeamContract

data class RandomTeam(override val playerId: Int,
                      override val playerName: String,
                      override val teamName: String,
                      override val teamId: Int?,
                      override val image: String,
                      override val nationality: String,
                      override val potential: Int,
                      override val age: Int,
                      override val club: String,
                      override var value: Long,
                      override var wage: Long,
                      override val logox2: String?,
                      override val logox4: String?,
                      override val logox6: String?,
                      override var average: Float,
                      override var eleven_average: Float,
                      override var quality: Float) : PlayerContract, TeamContract {
    var positions: MutableList<String> = mutableListOf()
}