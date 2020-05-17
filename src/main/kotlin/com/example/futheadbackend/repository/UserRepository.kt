package com.example.futheadbackend.repository

import com.example.futheadbackend.dto.entity.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository : JpaRepository<User, String>