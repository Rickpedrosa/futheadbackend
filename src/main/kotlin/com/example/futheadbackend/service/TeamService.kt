package com.example.futheadbackend.service

import com.example.futheadbackend.dto.entity.Team
import com.example.futheadbackend.repository.TeamRepository
import com.example.futheadbackend.repository.impls.TeamRepositoryImpl
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class TeamService(@Autowired private val teamRepository: TeamRepository) : TeamRepositoryImpl {
    override fun getTeamsByText(club: String): List<Team> {
        return teamRepository.getTeamsByText(club)
    }
}