package com.example.futheadbackend.controller

import com.example.futheadbackend.dto.entity.Tournament
import com.example.futheadbackend.dto.entity.TournamentUserPlayer
import com.example.futheadbackend.dto.pojo.TournamentRequest
import com.example.futheadbackend.dto.pojo.TournamenteUserPlayerRequest
import com.example.futheadbackend.dto.response.OnSaveTournamentResponse
import com.example.futheadbackend.service.TournamentService
import com.example.futheadbackend.service.TournamentUserPlayerService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@CrossOrigin(origins = ["http://localhost:4200"])
@RestController
@RequestMapping(value = ["/tournament"])
class TournamentController(@Autowired private val tournamentService: TournamentService,
                           @Autowired private val tournamentUserPlayerService: TournamentUserPlayerService) {

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

    @RequestMapping(
            path = ["/players/add"],
            method = [RequestMethod.GET],
            consumes = ["application/json"],
            produces = ["application/json"]
    )
    fun addPlayersToTournament(@RequestBody request: TournamenteUserPlayerRequest): List<TournamentUserPlayer> {
        return tournamentUserPlayerService.addPlayersToTournament(request)
    }
}
