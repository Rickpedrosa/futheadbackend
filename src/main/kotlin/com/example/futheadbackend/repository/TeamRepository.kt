package com.example.futheadbackend.repository

import com.example.futheadbackend.dto.entity.TEAMS_BY_NAME
import com.example.futheadbackend.dto.entity.Team
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository

interface TeamRepository : CrudRepository<Team, String> {
    @Query(value = TEAMS_BY_NAME, nativeQuery = true)
    fun getTeamsByText(club: String): List<Team>
}