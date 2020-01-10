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