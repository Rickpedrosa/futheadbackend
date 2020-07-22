package com.example.futheadbackend.controller

import com.example.futheadbackend.dto.entity.Tournament
import com.example.futheadbackend.dto.pojo.TournamentRequest
import com.example.futheadbackend.dto.response.OnSaveTournamentResponse
import com.example.futheadbackend.service.TournamentService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@CrossOrigin(origins = ["http://localhost:4200"])
@RestController
@RequestMapping(value = ["/tournament"])
class TournamentController(@Autowired private val tournamentService: TournamentService) {

    @RequestMapping(
            path = ["/create"],
            method = [RequestMethod.GET],
            consumes = ["application/json"],
            produces = ["application/json"]
    )
    fun createTournament(@RequestBody tournamentRequest: TournamentRequest): OnSaveTournamentResponse {
        val tournament = Tournament(
                0,
                tournamentRequest.tournamentName,
                tournamentRequest.type,
                tournamentRequest.creationDate
        )
        return tournamentService.createTournament(tournament, tournamentRequest.roundTrip, tournamentRequest.users)
    }
}
