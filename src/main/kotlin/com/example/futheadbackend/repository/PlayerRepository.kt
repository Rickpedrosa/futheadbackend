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

    // FILTRO DE JUGADORES
//    SELECT DISTINCT p.*
//    FROM players p INNER JOIN playerpositions pos ON p.id = pos.player_id
//    WHERE potential >= 85 AND value >= 10000000 AND pos.pos RLIKE 'CF|RW|ST' AND p.id NOT IN (158023)
//    ORDER BY potential DESC
}