package com.example.futheadbackend.repository.impls

import com.example.futheadbackend.dto.entity.Team
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable

interface TeamRepositoryImpl {
    fun getClubsFilteredByText(club: String): List<Team?>
    fun getGoldenClubs(pageable: Pageable): Page<Team>
    fun getSilverClubs(pageable: Pageable): Page<Team>
    fun getBronzeClubs(pageable: Pageable): Page<Team>
}