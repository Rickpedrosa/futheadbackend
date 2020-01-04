package com.example.futheadbackend.dto.contract

interface PlayerContract {
    val playerId: Int
    val playerName: String
    val image: String
    val nationality: String
    val potential: Int
    val age: Int
    val club: String
    var value: Long
    var wage: Long
}