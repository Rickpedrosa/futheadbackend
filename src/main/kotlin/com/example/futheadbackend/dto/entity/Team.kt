package com.example.futheadbackend.dto.entity

import com.example.futheadbackend.dto.contract.TeamContract
import javax.persistence.Entity
import javax.persistence.Id

@Entity
data class Team(
        @Id override val name: String,
        override val id: Int?,
        override val logox2: String?,
        override val logox4: String?,
        override val logox6: String?,
        override var average: Float,
        override var eleven_average: Float,
        override var quality: Float
) : TeamContract