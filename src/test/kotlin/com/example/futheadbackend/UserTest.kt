package com.example.futheadbackend


import com.example.futheadbackend.dto.entity.Day
import com.example.futheadbackend.dto.entity.Match
import com.example.futheadbackend.dto.entity.Tournament
import com.example.futheadbackend.dto.entity.TournamentUser
import com.example.futheadbackend.repository.DayRepository
import com.example.futheadbackend.repository.MatchRepository
import com.example.futheadbackend.repository.TournamentRepository
import com.example.futheadbackend.repository.TournamentUserRepository
import com.example.futheadbackend.utils.isOdd
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import javax.transaction.Transactional

@SpringBootTest
class TournamentTest(
        @Autowired private val tournamentRepository: TournamentRepository,
        @Autowired private val dayRepository: DayRepository,
        @Autowired private val matchRepository: MatchRepository,
        @Autowired private val tournamentUserRepository: TournamentUserRepository
) {

    @Test
    //@Transactional
    fun testSaveJPAMethodTournament() {
        //tournamentRepository.deleteAll()
        val tour = Tournament(0, "Prueba220720201159", "LG", "hoy")
        val players = listOf("Pepito", "Jaimito", "Astorguecito")
        val saved = tournamentRepository.save(tour)
        players.forEach {
            tournamentUserRepository.save(TournamentUser(0, saved.id, it))
        }
        println(saved)
    }

    @Test
    fun testSaveJPAMethodDay() {
        dayRepository.deleteAll()
        matchRepository.deleteAll()
        val tournament = tournamentRepository.findById(2)
        val roundTrip = true
        val players = listOf("Pepito", "Jaimito", "Astorguecito")
        val daysGoOnly = if (players.size.isOdd()) players.size else (players.size - 1)
        val daysRoundTrip = if (players.size.isOdd()) (players.size * 2) else (players.size * 2) - 2
        val numberOfDays = if (roundTrip) daysRoundTrip else daysGoOnly
        var matchesPerJornada = players.toMutableList()

        val listOfDays = mutableListOf<Day>()
        for (i in 0 until numberOfDays) {
            listOfDays.add(dayRepository.save(Day(0, "xd", tournament.get())))
        }

        val listOfMatches: MutableList<Match> = mutableListOf()
        if (roundTrip) {
            for (i in 0 until daysRoundTrip) {
                if (i >= daysRoundTrip / 2) {
                    matchesPerJornada.getMapFromList(true).forEach {
                        if (it.first != "-" && it.second != "-") {
                            listOfMatches.add(matchRepository.save(Match(
                                    0,
                                    listOfDays[i],
                                    tournament.get(),
                                    "start",
                                    "end",
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
                                    listOfDays[i],
                                    tournament.get(),
                                    "start",
                                    "end",
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
                                listOfDays[i],
                                tournament.get(),
                                "start",
                                "end",
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
        listOfMatches.forEach(::println)
    }
}

fun MutableList<String>.reorderItemsForward(): MutableList<String> {
    val element = this[this.size - 1]
    val fixedPosition = if (this.size.isOdd()) 0 else 1
    this.removeAt(this.size - 1)
    this.add(fixedPosition, element)
    return this
}

fun MutableList<String>.getMapFromList(swapHomeForAway: Boolean = false): MutableList<Pair<String, String>> {
    val map = mutableListOf<Pair<String, String>>()
    val listOne = this.slice(0 until (this.size / 2)).toMutableList()
    val sizeForLoop = if (this.size.isOdd()) {
        listOne.add("-")
        listOne.size
    } else {
        (this.size / 2)
    }
    val listTwo = this.minus(listOne)
    for (i in 0 until sizeForLoop) {
        if (swapHomeForAway) {
            map.add(Pair(listTwo[i], listOne[i]))
        } else {
            map.add(Pair(listOne[i], listTwo[i]))
        }
    }
    return map
}
