package com.example.futheadbackend.dto.sqldatarow

import com.example.futheadbackend.dto.pojo.PlayerWithPositions
import java.util.stream.Stream

interface PlayerWithPosSQLRow {
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

const val FROM_CLUB = "SELECT p.*, pos.pos AS position " +
        "FROM players p INNER JOIN playerpositions pos ON pos.player_id = p.id " +
        "INNER JOIN teams t ON t.name = p.club " +
        "WHERE p.club LIKE :club " +
        "ORDER BY p.potential DESC"

fun PlayerWithPosSQLRow.streamOfPlayer(): Stream<PlayerWithPositions> {
    return Stream.of(PlayerWithPositions(
            this.getId(),
            this.getName(),
            this.getImage(),
            this.getNationality(),
            this.getAge(),
            this.getClub(),
            this.getValue(),
            this.getWage(),
            this.getPotential()
    ))
}