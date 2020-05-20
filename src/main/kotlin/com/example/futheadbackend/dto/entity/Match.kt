package com.example.futheadbackend.dto.entity

import javax.persistence.*

@Entity
@Table(name = "match_fifa")
data class Match(
        @Id @GeneratedValue(strategy = GenerationType.AUTO) val id: Int,
        @Column(name = "id_day") val idDay: Int,
        @Column(name = "id_tour") val idTour: Int,
        val timeStart: String,
        val timeEnd: String,
        val scoreHome: Int,
        val scoreAway: Int,
        @Column(name = "id_event") val idEvent: Int,
        @Column(name = "id_type") val idType: Int
)