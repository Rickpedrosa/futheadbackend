package com.example.futheadbackend.dto.entity

import javax.persistence.*

@Entity
@Table(name = "match_fifa")
data class Match(
        @Id @GeneratedValue(strategy = GenerationType.AUTO) val id: Int,
        @ManyToOne
        @JoinColumn(name = "id_day")
        val day: Day,
        @ManyToOne
        @JoinColumn(name = "id_tour")
        val tournament: Tournament,
        val timeStart: String,
        val timeEnd: String,
        val scoreHome: Int,
        val scoreAway: Int,
        @Column(name = "id_event") val idEvent: Int,
        @Column(name = "id_type") val idType: String,
        @Column(name = "participant_home") val participantHome: String,
        @Column(name = "participant_away") val participantAway: String
)