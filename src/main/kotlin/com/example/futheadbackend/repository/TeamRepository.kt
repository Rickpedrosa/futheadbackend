package com.example.futheadbackend.repository

import com.example.futheadbackend.dto.entity.Team
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository

interface TeamRepository : CrudRepository<Team, String> {
    @Query(value = TEAMS_BY_NAME, nativeQuery = true)
    fun getClubsFilteredByText(id: String): List<Team?>

    @Query(value = FIVE_STARS_CLUBS,
            countQuery = FIVE_STARS_CLUBS_COUNT,
            nativeQuery = true)
    fun getFiveStarsClubs(pageable: Pageable): Page<Team>
}

const val TEAMS_BY_NAME = "SELECT * FROM teams WHERE name LIKE ?1"
const val FIVE_STARS_CLUBS = "SELECT * FROM teams WHERE quality = 5 ORDER BY quality DESC"
const val FIVE_STARS_CLUBS_COUNT = "SELECT COUNT(name) " +
        "FROM teams " +
        "WHERE quality = 5 " +
        "ORDER BY quality DESC"