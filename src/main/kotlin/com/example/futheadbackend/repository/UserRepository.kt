package com.example.futheadbackend.repository

import com.example.futheadbackend.dto.entity.Tournament
import com.example.futheadbackend.dto.entity.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

interface UserRepository : JpaRepository<User, String> {
//    @Query(value = "SELECT * FROM tournament t INNER JOIN tournament_user tu on t.id = tu.id_tour " +
//            "WHERE tu.id_user = :username ",
//            nativeQuery = true
//    )
//    fun getTournamentsPerUser(userName: String): List<Tournament>
}