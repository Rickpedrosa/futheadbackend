package com.example.futheadbackend.repository.impls

import com.example.futheadbackend.dto.entity.Player
import com.example.futheadbackend.dto.pojo.PlayerWithPositions
import com.example.futheadbackend.dto.pojo.SearchCriteria

interface PlayerRepositoryImpl {
    // interfaz que en conjunta con la original sacará los datos que de verdad se quieren
    fun findPlayerWithPositions(club: String): List<PlayerWithPositions>
    fun getPlayerById(id: Int): Player?
    fun getPlayersBySearchCriteria(criteria: List<SearchCriteria>): List<Player?>
}