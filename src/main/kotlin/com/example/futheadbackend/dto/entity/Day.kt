package com.example.futheadbackend.dto.entity

import javax.persistence.*

@Entity
@Table(name = "day")
data class Day(
        @Id @GeneratedValue(strategy = GenerationType.AUTO) val id: Int,
        @Column(name = "day_date") val dayDate: String,
        @Column(name = "id_tour") val idTour: Int
)