package com.example.futheadbackend.dto.entity

import com.example.futheadbackend.dto.contract.PlayerContract
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "players")
data class Player(
        @Id @Column(name = "id") override val playerId: Int,
        @Column(name = "name") override val playerName: String,
        override val image: String,
        override val nationality: String,
        override val age: Int,
        override val club: String,
        override var value: Long,
        override var wage: Long,
        override val potential: Int
) : PlayerContract

