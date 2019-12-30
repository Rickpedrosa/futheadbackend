package com.example.futheadbackend.dto.entity

import com.example.futheadbackend.dto.contract.PlayerContract
import javax.persistence.Entity
import javax.persistence.Id

@Entity
data class Player(
        @Id override val id: Int,
        override val name: String,
        override val image: String,
        override val nationality: String,
        override val age: Int,
        override val club: String,
        override var value: Long,
        override var wage: Long,
        override val potential: Int
) : PlayerContract