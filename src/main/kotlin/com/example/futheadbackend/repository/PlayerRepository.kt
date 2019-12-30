package com.example.futheadbackend.repository

import com.example.futheadbackend.dto.sqldatarow.PlayerWithPosSQLRow
import com.example.futheadbackend.dto.entity.Player
import com.example.futheadbackend.dto.sqldatarow.FROM_CLUB
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository

interface PlayerRepository : CrudRepository<Player, Int> {
    @Query(value = FROM_CLUB, nativeQuery = true)
    fun findPlayerWithPositions(club: String): List<PlayerWithPosSQLRow>
}