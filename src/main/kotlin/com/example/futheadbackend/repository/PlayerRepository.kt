package com.example.futheadbackend.repository

import com.example.futheadbackend.dto.sqldatarow.PlayerWithPosSQLRow
import com.example.futheadbackend.dto.entity.Player
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository

interface PlayerRepository : CrudRepository<Player, Int> {
    @Query(value = FROM_CLUB, nativeQuery = true)
    fun findPlayerWithPositions(club: String): List<PlayerWithPosSQLRow>

    @Query(value = PLAYER_BY_ID, nativeQuery = true)
    fun findPlayerById(id: Int): Player?

//    @Query(value = GOLD_PLAYERS_WITH_OFFSET,
//            countQuery = GOLD_PLAYERS_COUNT,
//            nativeQuery = true)
//    fun getSliceOfGoldPlayers(): Page<PlayerWithPosSQLRow>
}

const val FROM_CLUB = "SELECT p.*, pos.pos AS position " +
        "FROM players p INNER JOIN playerpositions pos ON pos.player_id = p.id " +
        "INNER JOIN teams t ON t.name = p.club " +
        "WHERE p.club LIKE :club " +
        "ORDER BY p.potential DESC"

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

const val PLAYER_BY_ID = "SELECT * FROM players WHERE id = :id"
