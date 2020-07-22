package com.example.workspace

import com.example.futheadbackend.utils.getMapFromList
import com.example.futheadbackend.utils.isOdd
import com.example.futheadbackend.utils.reorderItemsForward

fun main() {
    tournament()
}

fun tournament() {
    val players = listOf(10, 20, 30)
    val idaYVuelta = true
    val jornadasIdaOnly = if (players.size.isOdd()) players.size else (players.size - 1)
    val jornadasIdaVuelta = if (players.size.isOdd()) (players.size * 2) else (players.size * 2) - 2
    var matchesPerJornada = players.toMutableList()

//    if (idaYVuelta) {
//        for (i in 0 until jornadasIdaVuelta) {
//            println("Partidos de la jornada ${i + 1}")
//            if (i >= jornadasIdaVuelta / 2) {
//                matchesPerJornada.getMapFromList(true).forEach(::println)
//            } else {
//                matchesPerJornada.getMapFromList().forEach(::println)
//            }
//            matchesPerJornada = matchesPerJornada.reorderItemsForward()
//            println()
//        }
//    } else {
//        for (i in 0 until jornadasIdaOnly) {
//            println("Partidos de la jornada ${i + 1}")
//            matchesPerJornada.getMapFromList().forEach(::println)
//            matchesPerJornada = matchesPerJornada.reorderItemsForward()
//            println()
//        }
//    }

}
