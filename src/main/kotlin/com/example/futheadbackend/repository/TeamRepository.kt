package com.example.futheadbackend.repository

import com.example.futheadbackend.dto.entity.Team
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository

interface TeamRepository : CrudRepository<Team, String> {
    @Query(value = "SELECT * FROM teams WHERE name LIKE ?1", nativeQuery = true)
    fun getClubsFilteredByText(id: String): List<Team?>

    @Query(value = "SELECT * FROM teams WHERE quality BETWEEN 4.5 AND 5 ORDER BY quality DESC",
            countQuery = "SELECT COUNT(name) FROM teams WHERE quality BETWEEN 4.5 AND 5 ORDER BY quality DESC",
            nativeQuery = true)
    fun getGoldenClubs(pageable: Pageable): Page<Team>

    @Query(value = "SELECT * FROM teams WHERE quality BETWEEN 4 AND 3 ORDER BY quality DESC",
            countQuery = "SELECT COUNT(name) FROM teams WHERE quality BETWEEN 4 AND 3 ORDER BY quality DESC",
            nativeQuery = true)
    fun getSilverClubs(pageable: Pageable): Page<Team>

    @Query(value = "SELECT * FROM teams WHERE quality < 3 ORDER BY quality DESC",
            countQuery = "SELECT COUNT(name) FROM teams WHERE quality < 3 ORDER BY quality DESC",
            nativeQuery = true)
    fun getBronzeClubs(pageable: Pageable): Page<Team>
}