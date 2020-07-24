package com.example.futheadbackend.dto.entity

import javax.persistence.*

@Entity
@Table(name = "tournament_user_player")
data class TournamentUserPlayer(
        @Id @GeneratedValue(strategy = GenerationType.AUTO) val id: Int,
        @Column(name = "tournament_id") val tournamentId: Int,
        @Column(name = "username") val username: String,
        @Column(name = "player_id") val playerId: Int
)