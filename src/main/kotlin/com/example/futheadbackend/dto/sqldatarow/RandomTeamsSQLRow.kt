package com.example.futheadbackend.dto.sqldatarow

interface RandomTeamsSQLRow {
    fun getClubName(): String
    fun getClubId(): Int?
    fun getLogox2(): String?
    fun getLogox4(): String?
    fun getLogox6(): String?
    fun getAverage(): Float
    fun getTeamAverage(): Float
    fun getQuality(): Float
    fun getId(): Int
    fun getName(): String
    fun getImage(): String
    fun getNationality(): String
    fun getAge(): Int
    fun getClub(): String
    fun getValue(): Long
    fun getWage(): Long
    fun getPotential(): Int
    fun getPosition(): String
}