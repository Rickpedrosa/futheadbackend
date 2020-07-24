package com.example.futheadbackend.dto.entity

import org.hibernate.annotations.DynamicUpdate
import javax.persistence.*

@Entity
@Table(name = "match_fifa")
@DynamicUpdate
data class Match(
        @Id @GeneratedValue(strategy = GenerationType.AUTO) val id: Int,
        @ManyToOne
        @JoinColumn(name = "id_day")
        val day: Day,
        @ManyToOne
        @JoinColumn(name = "id_tour")
        val tournament: Tournament,
        var timeStart: String,
        var timeEnd: String,
        var scoreHome: Int,
        var scoreAway: Int,
        @Column(name = "id_event") var idEvent: Int,
        @Column(name = "id_type") var idType: String,
        @Column(name = "participant_home") val participantHome: String,
        @Column(name = "participant_away") val participantAway: String
)