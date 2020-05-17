package com.example.workspace

import java.util.*

fun main() {
    tournament()
}

fun tournament() {
    val players = listOf(10, 20, 30, 40)
    val idaYVuelta = true
    val jornadasIdaOnly = if (players.size.isOdd()) players.size else (players.size - 1)
    val jornadasIdaVuelta = if (players.size.isOdd()) (players.size * 2) else (players.size * 2) - 2
    var matchesPerJornada = players.toMutableList()

    if (idaYVuelta) {
        for (i in 0 until jornadasIdaVuelta) {
            println("Partidos de la jornada ${i + 1}")
            if (i >= jornadasIdaVuelta / 2) {
                matchesPerJornada.getMapFromList(true).forEach(::println)
            } else {
                matchesPerJornada.getMapFromList().forEach(::println)
            }
            matchesPerJornada = matchesPerJornada.reorderItemsForward()
            println()
        }
    } else {
        for (i in 0 until jornadasIdaOnly) {
            println("Partidos de la jornada ${i + 1}")
            matchesPerJornada.getMapFromList().forEach(::println)
            matchesPerJornada = matchesPerJornada.reorderItemsForward()
            println()
        }
    }

}

fun MutableList<Int>.reorderItemsForward(): MutableList<Int> {
    val element = this[this.size - 1]
    val fixedPosition = if (this.size.isOdd()) 0 else 1
    this.removeAt(this.size - 1)
    this.add(fixedPosition, element)
    return this
}

fun MutableList<Int>.getMapFromList(swapHomeForAway: Boolean = false): MutableList<Pair<Int, Int>> {
    val map = mutableListOf<Pair<Int, Int>>()
    val listOne = this.slice(0 until (this.size / 2)).toMutableList()
    val sizeForLoop = if (this.size.isOdd()) {
        listOne.add(-1)
        listOne.size
    } else {
        (this.size / 2)
    }
    val listTwo = this.minus(listOne)
    for (i in 0 until sizeForLoop) {
        if (swapHomeForAway) {
            map.add(Pair(listTwo[i], listOne[i]))
        } else {
            map.add(Pair(listOne[i], listTwo[i]))
        }
    }
    return map
}

fun Int.isOdd(): Boolean {
    return this % 2 == 1
}