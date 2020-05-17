package com.example.futheadbackend.dto.pojo

data class PlayerWithPositions(
        val playerId: Int,
        val playerName: String,
        val image: String,
        val nationality: String,
        val age: Int,
        val club: String,
        var value: Long,
        var wage: Long,
        val potential: Int
) {
    var positions: MutableList<String> = mutableListOf()
}

