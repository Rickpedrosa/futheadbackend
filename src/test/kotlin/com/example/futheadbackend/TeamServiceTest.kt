package com.example.futheadbackend

import com.example.futheadbackend.dto.entity.Team
import com.example.futheadbackend.dto.pojo.PlayerWithPositions
import com.example.futheadbackend.dto.pojo.RandomTeam
import com.example.futheadbackend.dto.pojo.SearchCriteria
import com.example.futheadbackend.repository.PlayerRepository
import com.example.futheadbackend.repository.TeamRepository
import com.example.futheadbackend.specifications.PlayerSpecifications
//import com.example.futheadbackend.specifications.withPosition
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.data.jpa.domain.Specification.*
import java.util.stream.Stream
import kotlin.streams.toList

@SpringBootTest
class TeamServiceTest(@Autowired private val teamRepository: TeamRepository,
                      @Autowired private val playerRepository: PlayerRepository) {
    @Test
    fun testAPICall() {
        val id = "%wakandaksdkadka%"
        println("${teamRepository.getClubsFilteredByText(id = id)}")
    }

    @Test
    fun trySpecifications() {
        val spec = PlayerSpecifications(SearchCriteria(
                "potential",
                ">",
                "85"))
                .and(PlayerSpecifications(SearchCriteria(
                        "nationality",
                        ":",
                        "Spain")))
                ?.and(PlayerSpecifications(SearchCriteria(
                        "age",
                        ">",
                        "30")))
        val players = playerRepository.findAll(where(spec))

        println("${players.size}")
        players.forEach(::println)
    }

    @Test
    fun tryRandomTeams() {
        val datasource = teamRepository.getRandomClubs(2)
        val randomTeams: MutableList<RandomTeam> = mutableListOf()
        val clubs = datasource
                .stream()
                .flatMap {
                    Stream.of(Team(
                            it.getClubName(),
                            it.getClubId(),
                            it.getLogox2(),
                            it.getLogox4(),
                            it.getLogox6(),
                            it.getAverage(),
                            it.getTeamAverage(),
                            it.getQuality()
                    ))
                }.distinct().toList()
        val players = datasource
                .stream()
                .flatMap {
                    Stream.of(PlayerWithPositions(
                            it.getId(),
                            it.getName(),
                            it.getImage(),
                            it.getNationality(),
                            it.getAge(),
                            it.getClub(),
                            it.getValue(),
                            it.getWage(),
                            it.getPotential()
                    ))
                }.distinct().toList()
        datasource.forEach { u ->
            players.forEach {
                if (it.playerId == u.getId()) {
                    it.positions.add(u.getPosition())
                }
            }
        }
        clubs.forEach { u ->
            randomTeams.add(RandomTeam(
                    u,
                    players.filter {
                        it.club === u.teamName
                    }
            ))
        }
        players.forEach(::println)
    }
//    @Test
//    fun testPlayerCall() {
//        println("${playerRepository.findPlayerById(20801)}")
//    }

//    @Test
//    fun xd() {
//        playerRepository.findAll(where(withPosition("GK"))).forEach(::println)
//    }
}
