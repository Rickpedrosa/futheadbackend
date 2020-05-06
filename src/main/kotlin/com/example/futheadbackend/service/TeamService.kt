package com.example.futheadbackend.service

import com.example.futheadbackend.dto.entity.Team
import com.example.futheadbackend.dto.pojo.RandomTeam
import com.example.futheadbackend.repository.TeamRepository
import com.example.futheadbackend.repository.impls.TeamRepositoryImpl
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

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
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}