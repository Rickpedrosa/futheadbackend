package com.example.futheadbackend.repository.impls

import com.example.futheadbackend.dto.entity.Tournament
import com.example.futheadbackend.dto.entity.User
import com.example.futheadbackend.dto.response.OnSaveUserResponse

interface UserRepositoryImpl {
    fun registerUser(user: User): OnSaveUserResponse
    fun login(userName: String, password: String)
    //fun getTournamentsPerUser(userName: String): List<Tournament>
}