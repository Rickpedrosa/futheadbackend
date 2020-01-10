package com.example.futheadbackend.repository.impls

import com.example.futheadbackend.dto.entity.Team
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable

interface TeamRepositoryImpl {
    fun getClubsFilteredByText(club: String): List<Team?>
    fun getFiveStarsClubs(pageable: Pageable): Page<Team>
}