package com.example.futheadbackend.repository.impls

import com.example.futheadbackend.dto.entity.Match
import com.example.futheadbackend.dto.pojo.MatchUpdateRequest

interface MatchRepositoryImpl {
    fun updateMatch(matchUpdateRequest: MatchUpdateRequest): Match
}