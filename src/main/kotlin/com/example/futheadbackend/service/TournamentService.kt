package com.example.futheadbackend.service

import com.example.futheadbackend.dto.entity.Day
import com.example.futheadbackend.dto.entity.Match
import com.example.futheadbackend.dto.entity.Tournament
import com.example.futheadbackend.dto.entity.TournamentUser
import com.example.futheadbackend.dto.response.*
import com.example.futheadbackend.repository.DayRepository
import com.example.futheadbackend.repository.MatchRepository
import com.example.futheadbackend.repository.TournamentRepository
import com.example.futheadbackend.repository.TournamentUserRepository
import com.example.futheadbackend.repository.impls.TournamentRepositoryImpl
import com.example.futheadbackend.utils.getMapFromList
import com.example.futheadbackend.utils.isOdd
import com.example.futheadbackend.utils.reorderItemsForward
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import javax.transaction.Transactional

@Suppress("DuplicatedCode")
@Service
@Transactional
class TournamentService(
        @Autowired private val tournamentRepository: TournamentRepository,
        @Autowired private val dayRepository: DayRepository,
        @Autowired private val matchRepository: MatchRepository,
        @Autowired private val tournamentUserRepository: TournamentUserRepository
) : TournamentRepositoryImpl {
    private val timeFormatter: DateTimeFormatter = DateTimeFormatter.ofPattern("DD/MM/yyyy HH:mm:ss")
//    LocalDateTime.now().format(timeFormatter)
    override fun createTournament(
            tournament: Tournament,
            roundTrip: Boolean,
            usersToPlay: List<String>
    ): OnSaveTournamentResponse {
        val tournamentResponse = getTournamentResponseObject(tournament, usersToPlay)
        val daysResponse = getDaysResponseObject(tournament, roundTrip, usersToPlay)
        return OnSaveTournamentResponse(
                DataTournament(tournamentResponse, daysResponse)
        )
    }

    private fun getDaysResponseObject(tournament: Tournament, roundTrip: Boolean, usersToPlay: List<String>): List<DayResponse> {
        val daysGoOnly = if (usersToPlay.size.isOdd()) usersToPlay.size else (usersToPlay.size - 1)
        val daysRoundTrip = if (usersToPlay.size.isOdd()) (usersToPlay.size * 2) else (usersToPlay.size * 2) - 2
        val numberOfDays = if (roundTrip) daysRoundTrip else daysGoOnly
        val listOfDays = mutableListOf<Day>()
        for (i in 0 until numberOfDays) {
            listOfDays.add(dayRepository.save(Day(0, "", tournament)))
        }
        val matches = getMatchesResponseObject(listOfDays, usersToPlay, tournament, roundTrip, daysRoundTrip, daysGoOnly)
        val dayResponseList = mutableListOf<DayResponse>()
        listOfDays.forEach { day ->
            dayResponseList.add(DayResponse(
                    day.id,
                    day.dayDate,
                    matches.filter { it.dayId == day.id }
            ))
        }
        return dayResponseList
    }

    private fun getMatchesResponseObject(days: List<Day>,
                                         usersToPlay: List<String>,
                                         tournament: Tournament,
                                         roundTrip: Boolean,
                                         daysRoundTrip: Int,
                                         daysGoOnly: Int
    ): List<MatchResponse> {
        var matchesPerJornada = usersToPlay.toMutableList()

        val listOfMatches: MutableList<Match> = mutableListOf()
        if (roundTrip) {
            for (i in 0 until daysRoundTrip) {
                if (i >= daysRoundTrip / 2) {
                    matchesPerJornada.getMapFromList(true).forEach {
                        if (it.first != "-" && it.second != "-") {
                            listOfMatches.add(matchRepository.save(Match(
                                    0,
                                    days[i],
                                    tournament,
                                    "",
                                    "",
                                    0,
                                    0,
                                    15,
                                    "OL",
                                    it.first,
                                    it.second
                            )))
                        }
                    }
                } else {
                    matchesPerJornada.getMapFromList().forEach {
                        if (it.first != "-" && it.second != "-") {
                            listOfMatches.add(matchRepository.save(Match(
                                    0,
                                    days[i],
                                    tournament,
                                    "",
                                    "",
                                    0,
                                    0,
                                    15,
                                    "OL",
                                    it.first,
                                    it.second
                            )))
                        }
                    }
                }
                matchesPerJornada = matchesPerJornada.reorderItemsForward()
            }
        } else {
            for (i in 0 until daysGoOnly) {
                matchesPerJornada.getMapFromList().forEach {
                    if (it.first != "-" && it.second != "-") {
                        listOfMatches.add(matchRepository.save(Match(
                                0,
                                days[i],
                                tournament,
                                "",
                                "",
                                0,
                                0,
                                15,
                                "OL",
                                it.first,
                                it.second
                        )))
                    }
                }
                matchesPerJornada = matchesPerJornada.reorderItemsForward()
            }
        }
        return listOfMatches.map {
            MatchResponse(
                    it.id,
                    it.day.id,
                    it.timeStart,
                    it.timeEnd,
                    it.scoreHome,
                    it.scoreAway,
                    it.idEvent,
                    it.idType,
                    it.participantHome,
                    it.participantAway
            )
        }
    }

    private fun getTournamentResponseObject(tournament: Tournament, usersToPlay: List<String>): TournamentResponse {
        val tournament1 = tournamentRepository.save(tournament)
        usersToPlay.forEach {
            tournamentUserRepository.save(TournamentUser(0, tournament1.id, it))
        }
        return TournamentResponse(
                tournament1,
                usersToPlay
        )
    }
}