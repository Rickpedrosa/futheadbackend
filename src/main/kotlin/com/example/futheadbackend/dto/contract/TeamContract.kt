package com.example.futheadbackend.dto.contract

@Suppress("PropertyName")
interface TeamContract {
    val teamName: String
    val teamId: Int?
    val logox2: String?
    val logox4: String?
    val logox6: String?
    var average: Float
    var eleven_average: Float
    var quality: Float
}