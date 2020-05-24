package com.example.futheadbackend.repository.impls

import com.example.futheadbackend.dto.entity.Player
import com.example.futheadbackend.dto.pojo.PlayerWithPositions
import com.example.futheadbackend.dto.pojo.SearchCriteria
import java.util.*
import javax.transaction.Transactional

interface PlayerRepositoryImpl {
    // interfaz que en conjunta con la original sacará los datos que de verdad se quieren
    fun findPlayerWithPositions(club: String): List<PlayerWithPositions>
    fun getPlayerById(id: Int): Optional<Player>
    fun getPlayersBySearchCriteria(criteria: List<SearchCriteria>): List<Player?>
}