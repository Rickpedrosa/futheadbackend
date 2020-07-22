package com.example.futheadbackend.dto.entity

import javax.persistence.*

@Entity
@Table(name = "tournament_user")
data class TournamentUser(
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        @Column(name = "id")
        val id: Int,
        @Column(name = "id_tour")
        val tournament: Int,
        @Column(name = "id_user")
        val user: String
)