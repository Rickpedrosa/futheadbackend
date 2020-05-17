package com.example.futheadbackend.dto.response

import com.example.futheadbackend.dto.entity.User

data class OnSaveUserResponse(
        val user: User,
        val message: String,
        val code: Int
)