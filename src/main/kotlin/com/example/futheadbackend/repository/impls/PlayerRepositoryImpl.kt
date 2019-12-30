package com.example.futheadbackend.repository.impls

import com.example.futheadbackend.dto.pojo.PlayerWithPositions

interface PlayerRepositoryImpl {
    // interfaz que en conjunta con la original sacará los datos que de verdad se quieren
    fun findPlayerWithPositions(club: String): List<PlayerWithPositions>
}