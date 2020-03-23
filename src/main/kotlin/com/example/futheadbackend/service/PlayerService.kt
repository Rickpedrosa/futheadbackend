package com.example.futheadbackend.service

import com.example.futheadbackend.dto.entity.Player
import com.example.futheadbackend.dto.pojo.PlayerWithPositions
import com.example.futheadbackend.dto.pojo.SearchCriteria
import com.example.futheadbackend.dto.sqldatarow.streamOfPlayer
import com.example.futheadbackend.repository.PlayerRepository
import com.example.futheadbackend.repository.impls.PlayerRepositoryImpl
import com.example.futheadbackend.specifications.PlayerSpecifications
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
                if (it.playerId == u.getId()) {
                    it.positions.add(u.getPosition())
                }
            }
        }
        return players
    }

    override fun getPlayerById(id: Int): Player? {
        return playerRepository.findPlayerById(id)
    }

    override fun getPlayersBySearchCriteria(criteria: List<SearchCriteria>): List<Player?> {
        val fullSpecification = PlayerSpecifications(criteria[0])
        if (criteria.size > 1) {
            for (i in 1 until criteria.size) {
                fullSpecification.and(PlayerSpecifications(criteria[i]))
            }
        }
        return playerRepository.findAll(fullSpecification)
    }

}