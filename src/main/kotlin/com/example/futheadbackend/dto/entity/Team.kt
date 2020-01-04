package com.example.futheadbackend.dto.entity

import com.example.futheadbackend.dto.contract.TeamContract
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id

@Entity
data class Team(
        @Id @Column(name = "name") override val teamName: String,
        @Column(name = "id") override val teamId: Int?,
        override val logox2: String?,
        override val logox4: String?,
        override val logox6: String?,
        override var average: Float,
        override var eleven_average: Float,
        override var quality: Float
) : TeamContract

const val TEAMS_BY_NAME = "SELECT * FROM teams WHERE name LIKE :club LIMIT 20"