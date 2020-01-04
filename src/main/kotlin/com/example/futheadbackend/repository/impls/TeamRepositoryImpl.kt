package com.example.futheadbackend.repository.impls

import com.example.futheadbackend.dto.entity.Team

interface TeamRepositoryImpl {
    fun getTeamsByText(club: String): List<Team>
}