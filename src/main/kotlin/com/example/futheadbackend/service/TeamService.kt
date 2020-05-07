package com.example.futheadbackend.service

import com.example.futheadbackend.dto.entity.Team
import com.example.futheadbackend.dto.pojo.PlayerWithPositions
import com.example.futheadbackend.dto.pojo.RandomTeam
import com.example.futheadbackend.repository.TeamRepository
import com.example.futheadbackend.repository.impls.TeamRepositoryImpl
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import java.util.stream.Stream
import kotlin.streams.toList

@Service
class TeamService(@Autowired private val teamRepository: TeamRepository)
    : TeamRepositoryImpl {
    override fun getClubsFilteredByText(club: String): List<Team?> {
        return teamRepository.getClubsFilteredByText(club)
    }

    override fun getGoldenClubs(pageable: Pageable): Page<Team> {
        return teamRepository.getGoldenClubs(pageable)
    }

    override fun getSilverClubs(pageable: Pageable): Page<Team> {
        return teamRepository.getSilverClubs(pageable)
    }

    override fun getBronzeClubs(pageable: Pageable): Page<Team> {
        return teamRepository.getBronzeClubs(pageable)
    }

    override fun getRandomClubs(random: Int): List<RandomTeam> {
        val datasource = teamRepository.getRandomClubs(random)
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
                        it.club == u.teamName
                    }
            ))
        }
        return randomTeams
    }
}