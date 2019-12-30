package com.example.futheadbackend.dto.contract

interface PlayerContract {
    val id: Int
    val name: String
    val image: String
    val nationality: String
    val potential: Int
    val age: Int
    val club: String
    var value: Long
    var wage: Long
}