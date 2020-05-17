package com.example.futheadbackend.dto.entity

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id

@Entity
data class Team(
        @Id @Column(name = "name") val teamName: String,
        @Column(name = "id") val teamId: Int?,
        val logox2: String?,
        val logox4: String?,
        val logox6: String?,
        var average: Float,
        var eleven_average: Float,
        var quality: Float
)


