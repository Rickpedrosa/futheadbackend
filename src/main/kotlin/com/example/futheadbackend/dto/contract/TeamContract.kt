package com.example.futheadbackend.dto.contract

interface TeamContract {
    val name: String
    val id: Int?
    val logox2: String?
    val logox4: String?
    val logox6: String?
    var average: Float
    var eleven_average: Float
    var quality: Float
}