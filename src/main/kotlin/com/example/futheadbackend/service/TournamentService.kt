package com.example.futheadbackend.service

import com.example.futheadbackend.dto.entity.Tournament
import com.example.futheadbackend.dto.response.OnSaveTournamentResponse
import com.example.futheadbackend.repository.TournamentRepository
import com.example.futheadbackend.repository.impls.TournamentRepositoryImpl
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class TournamentService(@Autowired val tournamentRepository: TournamentRepository) : TournamentRepositoryImpl {
    override fun createTournament(tournament: Tournament, usersToPlay: List<String>): OnSaveTournamentResponse {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}