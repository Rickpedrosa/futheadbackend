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
    fun getPosition(): String
    fun getPotential(): Int
}

const val RANDOM_TEAMS = "SELECT t.name AS clubname, t.id AS clubid, t.logox2, t.logox4, t.logox6, t.average, " +
        "t.eleven_average AS teamaverage, t.quality, p.*, pos.pos AS position " +
        "FROM (SELECT * FROM teams WHERE quality BETWEEN 3 AND 4 ORDER BY RAND() LIMIT :random) t " +
        "INNER JOIN players p ON p.club = t.name " +
        "INNER JOIN playerpositions pos ON p.id = pos.player_id " +
        "ORDER BY t.name, p.potential DESC, p.name"

fun RandomTeamsSQLRow.streamOfRandomTeam(): Stream<RandomTeam> {
    return Stream.of(RandomTeam(
            this.getId(),
            this.getName(),
            this.getClub(),
            this.getClubId(),
            this.getImage(),
            this.getNationality(),
            this.getPotential(),
            this.getAge(),
            this.getClubName(),
            this.getValue(),
            this.getWage(),
            this.getLogox2(),
            this.getLogox4(),
            this.getLogox6(),
            this.getAverage(),
            this.getTeamAverage(),
            this.getQuality()
    ))
}