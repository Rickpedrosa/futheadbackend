package com.example.futheadbackend.service

import com.example.futheadbackend.dto.entity.Match
import com.example.futheadbackend.dto.pojo.MatchUpdateRequest
import com.example.futheadbackend.repository.MatchRepository
import com.example.futheadbackend.repository.impls.MatchRepositoryImpl
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class MatchService(@Autowired private val matchRepository: MatchRepository) : MatchRepositoryImpl {
    override fun updateMatch(matchUpdateRequest: MatchUpdateRequest): Match {
        val matchToUpdate = matchRepository.findById(matchUpdateRequest.id)
        matchToUpdate.ifPresent {
            it.timeStart = matchUpdateRequest.timeStart
            it.timeEnd = matchUpdateRequest.timeEnd
            it.idEvent = matchUpdateRequest.idEvent
            it.idType = matchUpdateRequest.idType
            it.scoreAway = matchUpdateRequest.scoreAway
            it.scoreHome = matchUpdateRequest.scoreHome
        }
        return matchRepository.save(matchToUpdate.get())
    }
}