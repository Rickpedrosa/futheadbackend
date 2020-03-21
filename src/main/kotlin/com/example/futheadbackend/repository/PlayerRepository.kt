package com.example.futheadbackend.repository

import com.example.futheadbackend.dto.sqldatarow.PlayerWithPosSQLRow
import com.example.futheadbackend.dto.entity.Player
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.JpaSpecificationExecutor
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository

interface PlayerRepository : JpaRepository<Player, Int>, JpaSpecificationExecutor<Player> {
    @Query(value = "SELECT p.*, pos.pos AS position " +
            "FROM players p INNER JOIN playerpositions pos ON pos.player_id = p.id INNER JOIN teams t ON t.name = p.club " +
            "WHERE p.club LIKE :club ORDER BY p.potential DESC",
            nativeQuery = true)
    fun findPlayerWithPositions(club: String): List<PlayerWithPosSQLRow>

    @Query(value = "SELECT * FROM players WHERE id = :id", nativeQuery = true)
    fun findPlayerById(id: Int): Player?
}


const val GOLD_PLAYERS_WITH_OFFSET = "SELECT p.*, pos.pos AS position " +
        "FROM (SELECT * " +
        "FROM players " +
        " WHERE potential >= 75 " +
        "ORDER BY potential DESC " +
        "LIMIT 30 OFFSET :offset) p " +
        "INNER JOIN playerpositions pos ON pos.player_id = p.id"

const val GOLD_PLAYERS_COUNT = "SELECT COUNT(id) " +
        "FROM players " +
        "WHERE potential >= 75 " +
        "ORDER BY potential DESC"

