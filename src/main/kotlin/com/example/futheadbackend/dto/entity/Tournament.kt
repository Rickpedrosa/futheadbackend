package com.example.futheadbackend.dto.entity

import javax.persistence.*

@Entity
@Table(name = "tournament")
data class Tournament(
        @Id @GeneratedValue(strategy = GenerationType.AUTO) val id: Int,
        val name: String,
        val type: String,
        @Column(name = "creation_date") val creationDate: String
)