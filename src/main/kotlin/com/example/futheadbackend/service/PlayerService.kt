package com.example.futheadbackend.service

import com.example.futheadbackend.dto.pojo.PlayerWithPositions
import com.example.futheadbackend.dto.sqldatarow.streamOfPlayer
import com.example.futheadbackend.repository.PlayerRepository
import com.example.futheadbackend.repository.impls.PlayerRepositoryImpl
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import kotlin.streams.toList

@Service
class PlayerService(@Autowired private val playerRepository: PlayerRepository) : PlayerRepositoryImpl {
    override fun findPlayerWithPositions(club: String): List<PlayerWithPositions> {
        val source = playerRepository.findPlayerWithPositions(club)
        val players = source.stream()
                .flatMap {
                    it.streamOfPlayer()
                }
                .distinct()
                .toList()
        source.forEach { u ->
            players.forEach {
                if (it.id == u.getId()) {
                    it.positions.add(u.getPosition())
                }
            }
        }
        return players
    }
}