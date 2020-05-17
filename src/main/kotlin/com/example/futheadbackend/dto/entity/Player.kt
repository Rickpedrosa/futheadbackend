package com.example.futheadbackend.dto.entity

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "players")
data class Player(
        @Id @Column(name = "id") val playerId: Int,
        @Column(name = "name") val playerName: String,
        val image: String,
        val nationality: String,
        val age: Int,
        val club: String,
        var value: Long,
        var wage: Long,
        val potential: Int
)

