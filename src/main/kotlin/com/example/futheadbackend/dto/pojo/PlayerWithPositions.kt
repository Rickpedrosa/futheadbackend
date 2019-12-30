package com.example.futheadbackend.dto.pojo

import com.example.futheadbackend.dto.contract.PlayerContract

data class PlayerWithPositions(
        override val id: Int,
        override val name: String,
        override val image: String,
        override val nationality: String,
        override val age: Int,
        override val club: String,
        override var value: Long,
        override var wage: Long,
        override val potential: Int
) : PlayerContract {
    var positions: MutableList<String> = mutableListOf()
}

