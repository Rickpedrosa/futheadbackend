package com.example.futheadbackend.service

import com.example.futheadbackend.dto.entity.Team
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

    override fun getFiveStarsClubs(pageable: Pageable): Page<Team> {
        return teamRepository.getFiveStarsClubs(pageable)
    }
}