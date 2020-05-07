package com.example.futheadbackend.dto.sqldatarow

import com.example.futheadbackend.dto.pojo.RandomTeam
import java.util.stream.Stream

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

//fun RandomTeamsSQLRow.streamOfRandomTeam(): Stream<RandomTeam> {
//    return Stream.of(RandomTeam(
//            this.getId(),
//            this.getName(),
//            this.getClub(),
//            this.getClubId(),
//            this.getImage(),
//            this.getNationality(),
//            this.getPotential(),
//            this.getAge(),
//            this.getClubName(),
//            this.getValue(),
//            this.getWage(),
//            this.getLogox2(),
//            this.getLogox4(),
//            this.getLogox6(),
//            this.getAverage(),
//            this.getTeamAverage(),
//            this.getQuality()
//    ))
//}