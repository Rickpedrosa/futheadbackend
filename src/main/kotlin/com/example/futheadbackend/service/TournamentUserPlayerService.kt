package com.example.futheadbackend.service

import com.example.futheadbackend.dto.entity.TournamentUserPlayer
import com.example.futheadbackend.dto.pojo.TournamenteUserPlayerRequest
import com.example.futheadbackend.repository.TournamentUserPlayerRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class TournamentUserPlayerService(
        @Autowired private val tournamentUserPlayerRepository: TournamentUserPlayerRepository
) {

    fun addPlayersToTournament(request: TournamenteUserPlayerRequest): List<TournamentUserPlayer> {
        val savedRows = mutableListOf<TournamentUserPlayer>()
        request.players.forEach { u ->
            savedRows.add(tournamentUserPlayerRepository.save(TournamentUserPlayer(
                    0, request.tournamentId, request.username, u
            )))
        }
        return savedRows
    }
}
